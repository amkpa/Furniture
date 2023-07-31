package com.softdyze.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "USERS")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	private String fullName;
	private String email;
	private String pwd;
	private Long mobileNo;
	private String gender;
	private LocalDate dob;
	private String accStatus;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<AddressEntity> address;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<OrderEntity> orders;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<ShipmentEntity> shipment;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<PaymentEntity> payment;
	
	@OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name="cart_id")
    private CartEntity cart;

	@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name="wishlist_id")
    private WishlistEntity wishList;

}
