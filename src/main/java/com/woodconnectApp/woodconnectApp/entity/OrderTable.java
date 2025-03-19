package com.woodconnectApp.woodconnectApp.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import jakarta.persistence.CascadeType;

//import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class OrderTable {
	@Id
	@GeneratedValue
    private Integer id;
	private String status;
	private String orderDate;
	private Double advanced_amount;
	private Double total_amount;
	private String delivery_date;
	private String assign_date;
	private String paymentStatus;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
	
	public User getUser() {
		return user;
	}
	public void setser(User user) {
		this.user = user;
	}
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "driverId", referencedColumnName = "id")
    private User driver;
	
	public User getDriver() {
		return driver;
	}
	public void setDriver(User driver) {
		this.driver = driver;
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
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
