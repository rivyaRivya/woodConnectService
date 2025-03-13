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
	
	@JsonManagedReference
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Payment> payment;
	
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
	
}
