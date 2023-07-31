package com.softdyze.binding;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Lob;

import lombok.Data;

@Data
public class OrderDetailsForm {
	
	
	private Long orderId;
	
	
	private Double totalAmount;
	private LocalDateTime orderDateTime;
	
	private String transactionId;
	
	private Long prodId;
	private String prodName;
	private Integer orderQty;
	private Lob prodImage;
	
	private Double orderAmount;


}
