package com.softdyze.binding;

import javax.persistence.Lob;

import lombok.Data;

@Data
public class DashboardResponse {

	private Long prodId;

	private String prodName;

	private String prodDesc;

	private Double prodPrice;

	private Integer prodQuantity;

	private Integer prodRating;

	private Lob prodImage;

}
