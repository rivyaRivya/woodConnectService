package com.woodconnectApp.woodconnectApp.entity;

import java.sql.Blob;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Product {
	@Id
	@GeneratedValue
    private Integer id;
	private String productname;
	private String price;
	private String manufacturedate;
	private String stock;
	@Lob
    private byte[] image;  // Store image as a byte array
	private String fileType;
	private String description;
	private String width;
	private String length;
	private String labourPrice;
	private String manufacturePrice;
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "woodType_id", nullable = true)
	private WoodType woodType;
	
	public WoodType getWoodType() {
		return woodType;
	}
	public void setWoodType(WoodType type) {
		this.woodType = type;
	}
	
//	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<OrderDetails> orderDetails;

}
