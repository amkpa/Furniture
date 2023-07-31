package com.softdyze.entity;

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
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
@Table(name = "ORDERITEM")
public class OrderItemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderItem_id")
	private Long orderItemId;
	
	private Integer orderQty;
	private Double orderAmount;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="order_id")
    private OrderEntity order;
	
	@OneToMany(mappedBy = "orderItem", cascade = CascadeType.ALL)
	//@JoinColumn(name = "prod_id")
	private List<ProductEntity> product;


}
