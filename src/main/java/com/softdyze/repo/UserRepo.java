package com.softdyze.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdyze.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {

	public UserEntity findByEmail(String email);

	public UserEntity findByEmailAndPwd(String email,String pwd);

}
