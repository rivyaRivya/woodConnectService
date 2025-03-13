package com.woodconnectApp.woodconnectApp.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Payment {
	@Id
	@GeneratedValue
    private Integer id;
	private String payment_status;
	private String payment_amount;
	private Date date;
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "order_id", nullable = true)
	private OrderTable order;
	
	public OrderTable getOrder() {
		return order;
	}
	public void setOrder(OrderTable user) {
		this.order = user;
	}
}
