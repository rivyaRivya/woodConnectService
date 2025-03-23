package com.woodconnectApp.woodconnectApp.entity;

import java.sql.Blob;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.JsonNode;

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
	private boolean isFeatured;
	
	@Lob
	 private String variant; // Stores the JSON as a Map

	    // Getter and Setter
	    public String getJsonData() {
	        return variant;
	    }

	    public void setJsonData(String jsonData) {
	        this.variant = jsonData;
	    }
	
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
	
	public boolean getIsFeatured() {
		return isFeatured;
	}
	public void setIsFeatured(boolean type) {
		this.isFeatured = type;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getManufacturedate() {
		return manufacturedate;
	}
	public void setManufacturedate(String manufacturedate) {
		this.manufacturedate = manufacturedate;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getLabourPrice() {
		return labourPrice;
	}
	public void setLabourPrice(String labourPrice) {
		this.labourPrice = labourPrice;
	}
	public String getManufacturePrice() {
		return manufacturePrice;
	}
	public void setManufacturePrice(String manufacturePrice) {
		this.manufacturePrice = manufacturePrice;
	}
	
//	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<OrderDetails> orderDetails;

}
