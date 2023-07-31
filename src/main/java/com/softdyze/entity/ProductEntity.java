package com.softdyze.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "PRODUCT")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_id")
	private Long prodId;
	private String prodName;
	private String prodDesc;
	private String prodType;
	private Double prodPrice;
	private Integer prodQuantity;
	private Integer prodRating;
	@Lob
	private Lob prodImage;
	

	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDate createdDate;

	// @LastModifiedDate
	@UpdateTimestamp
	private LocalDate updatedDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "wishlist_id")
	private WishlistEntity wishList;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private CategoryEntity category;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id")
	private CartEntity cart;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderItem_id")
	private OrderItemEntity orderItem;

}
