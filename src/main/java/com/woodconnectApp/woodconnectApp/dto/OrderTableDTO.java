package com.woodconnectApp.woodconnectApp.dto;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class OrderTableDTO {
	private Integer id;
	private String status;
	private String orderDate;
	private Double advanced_amount;
	private Double total_amount;
	private String delivery_date;
	private String assign_date;
	private List<ProductDTO> products;
	private Integer userId;
	private String username;
	private Integer driverId;
	private String driverName;
	private String paymentStatus;
	
	public OrderTableDTO(Integer id,String status,String orderDate,Double advanced_amount,
			Double total_amount,String delivery_date,String assign_date,Integer userId,String username,
			Integer driverId,String driverName,String paymentStatus){
		super();
		this.id = id;
		this.status = status;
		this.orderDate = orderDate;
		this.advanced_amount = advanced_amount;
		this.total_amount = total_amount;
		this.delivery_date = delivery_date;
		this.assign_date = assign_date;
		this.userId = userId;
		this.username = username;
		this.driverId = driverId;
		this.driverName= driverName;
		this.paymentStatus = paymentStatus;
	}
	
	public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Double getAdvanced_amount() {
		return advanced_amount;
	}

	public void setAdvanced_amount(Double advanced_amount) {
		this.advanced_amount = advanced_amount;
	}

	public Double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}

	public String getDelivery_date() {
		return delivery_date;
	}

	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}

	public String getAssign_date() {
		return assign_date;
	}

	public void setAssign_date(String assign_date) {
		this.assign_date = assign_date;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
}
