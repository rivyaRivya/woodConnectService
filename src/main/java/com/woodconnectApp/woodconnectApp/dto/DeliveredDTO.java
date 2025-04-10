package com.woodconnectApp.woodconnectApp.dto;

import lombok.Data;

@Data
public class DeliveredDTO {
	public DeliveredDTO(String productName, Integer quantity, Double amount, Integer productId) {
		// TODO Auto-generated constructor stub
		super();
		this.productId = productId;
		this.amount = amount;
		this.productName = productName;
		this.quantity = quantity;
	}
	private String productName;
	private Integer quantity;
	private Double amount;
	private Integer productId;
}
