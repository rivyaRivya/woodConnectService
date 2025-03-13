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
public class Review {
	@Id
	@GeneratedValue
    private Integer id;
	private String rating;
	private String review;
	
	
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
	private User user;

	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "product_id", nullable = true)
	private Product product;
	
}
