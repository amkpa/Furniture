package com.softdyze.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "Shipment")
public class ShipmentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shipment_id")
	
	private Long shipment_id;
	private String shipment_Date;
	
	private String fullName;
	private Long phoneNumber;
	private Long altrPhoneNumber;
	private Integer pincode;
	private String state;
	private String city;
	private String area;
	private String housenoBuildingName;
	private String landmark;
	private String addressType;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private UserEntity user;
	
	
	@OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name="order_id")
    private OrderEntity order;



}
