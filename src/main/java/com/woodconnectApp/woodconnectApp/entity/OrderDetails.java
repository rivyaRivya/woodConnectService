package com.woodconnectApp.woodconnectApp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class OrderDetails {
	@Id
	@GeneratedValue
    private Integer id;
	private Integer quantity;
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "orderTable_id", nullable = true)
	private OrderTable orderTable;
	
	public OrderTable getOrderTable() {
		return orderTable;
	}
	
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "product_id", nullable = true)
	private Product product;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

}
