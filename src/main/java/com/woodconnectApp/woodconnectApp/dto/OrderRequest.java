package com.woodconnectApp.woodconnectApp.dto;


import java.sql.Blob;
import java.util.Date;
import java.util.List;

public class OrderRequest {

    private Integer userId;
    private Double advanced_amount;
    private String paymentStatus;
    private Integer quantity;
	private String orderDate;
    private double total_amount;
    private String orderStatus;
	private Integer productId; 
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Double getAdvanced_amount() {
		return advanced_amount;
	}

	public void setAdvanced_amount(Double advanced_amount) {
		this.advanced_amount = advanced_amount;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

    public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
 // A list of product details (ID and quantity)

    // Getters and Setters
 

    public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return total_amount;
    }

    public void setTotalAmount(double totalAmount) {
        this.total_amount = totalAmount;
    }

}
