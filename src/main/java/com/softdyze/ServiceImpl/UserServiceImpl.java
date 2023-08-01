package com.softdyze.ServiceImpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softdyze.Service.UserService;
import com.softdyze.binding.LoginForm;
import com.softdyze.binding.SignUpForm;
import com.softdyze.entity.UserEntity;
import com.softdyze.repo.UserRepo;
import com.softdyze.utility.EmailUtility;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo usrRepo;

	@Autowired
	private EmailUtility emailUtils;
	@Autowired
	private HttpSession session;

	@Override
	public String login(LoginForm loginForm) {
		UserEntity entity = usrRepo.findByEmailAndPwd(loginForm.getEmail(), loginForm.getPwd());

		if (entity == null) {
			return "Invalid Credentials";
		}
		// create session and store user data in session
		session.setAttribute("userId", entity.getUserId());

		return "success";
	}

	@Override
	public boolean signup(SignUpForm signupForm) {

		UserEntity user = usrRepo.findByEmail(signupForm.getEmail());

		if (user != null) {
			return false;
		}

		// TODO: Copy data from binding obj to entity obj
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(signupForm, entity);

		// TODO:generate random pwd and set to object
//		String tempPwd = PwdUtils.generateRandomPwd();
//		entity.setPwd(tempPwd);

		// TODO:Set account status as LOCKED
//		entity.setAccStatus(AppConstants.STR_LOCKED);

		// TODO:Insert record
		usrRepo.save(entity);

		// TODO:Send email account
		String to = signupForm.getEmail();
		// String recipient = emailId;
		StringBuffer body = new StringBuffer();
		String subject = "Registration Successfull";
		body.append("" + "<html>" + "<body>" + "<h2 style='color:green;'>Welcome to Das Electronics</h2>" + "" + "Hi "
				+ signupForm.getFullName() + "," + "<br><br>Thanks for singing up with Das Electronics.<br>"
				+ "We are glad that you choose us. We invite you to check out our latest collection of new electonics appliances."
				+ "<br>We are providing upto 60% OFF on most of the electronic gadgets. So please visit our site and explore the collections."
				+ "<br><br>Our Online electronics is growing in a larger amount these days and we are in high demand so we thanks all of you for "
				+ "making us up to that level. We Deliver Product to your house with no extra delivery charges and we also have collection of most of the"
				+ "branded items.<br><br>As a Welcome gift for our New Customers we are providing additional 10% OFF Upto 500 Rs for the first product purchase. "
				+ "<br>To avail this offer you only have "
				+ "to enter the promo code given below.<br><br><br> PROMO CODE: " + "DAS300<br><br><br>"
				+ "Have a good day!<br>" + "" + "</body>" + "</html>");

		emailUtils.sendEmail(to, subject, body.toString());
		return true;
	}

	@Override
	public boolean forgotPwd(String email) {

		return false;
	}

}
