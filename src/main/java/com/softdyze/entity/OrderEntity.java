package com.softdyze.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "ORDERS")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long orderId;
	
	//private int orderQty;
	private Double totalAmount;
	private LocalDateTime orderDateTime;
	
	//@CreationTimestamp
	//private LocalDate createdOrderDate;

	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="shipment_id")
    private ShipmentEntity shipment;

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private UserEntity user;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="payment_id")
    private PaymentEntity payment;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItemEntity> orderItem;
}
