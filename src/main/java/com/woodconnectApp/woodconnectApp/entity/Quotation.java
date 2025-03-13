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
	@Lob
    private byte[] image;  
	private String response;
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
	private User user;
	
}
