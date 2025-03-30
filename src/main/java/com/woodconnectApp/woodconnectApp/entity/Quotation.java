package com.woodconnectApp.woodconnectApp.entity;

import java.sql.Blob;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Quotation {
	@Id
	@GeneratedValue
    private Integer id;
	private String description;
	private String status;
	private String quantity;
	private String color;
	private Integer woodTypeId;
	private String customerName;
	
	private String productName;
	private String dimension;
	private String discount;
	private String totalPrice;
	private String manufacturingCost;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Lob
    private byte[] image;  
	private String response;
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
	private User user;
	
}
