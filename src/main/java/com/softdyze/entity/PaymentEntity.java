package com.softdyze.entity;

import java.time.LocalDateTime;

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
@Table(name = "PAYMENTS")
public class PaymentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private Integer paymentId;
	private String transactionId;
	
	private String cardType;
	private String paymentCardName;
	private LocalDateTime paymentTime;
	private Double paymentPrice;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private UserEntity user;
	
	@OneToOne(mappedBy = "payment" ,cascade = CascadeType.ALL)
   // @JoinColumn(name="order_id")
    private OrderEntity order;

}
