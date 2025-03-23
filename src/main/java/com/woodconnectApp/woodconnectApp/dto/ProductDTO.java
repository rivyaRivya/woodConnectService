package com.woodconnectApp.woodconnectApp.dto;

import java.sql.Blob;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductDTO {
	private Integer id;
	private String productname;
	private String price;
	private String manufacture;
	private String stock;
	private String image;
	private Integer WoodType_id;
	private String woodtypename;
    private String fileType;
    private String description;
	private String width;
	private String length;
	private String labourPrice;
	private String manufacturePrice;
	private String variant;
	private String woodPrice;
	private boolean isFeatured;
	private byte[] display;
	private Integer quantity;
	public ProductDTO(Integer id,String productname,String price,
			String manufacture,String stock,String image,Integer WoodType_id,String woodtypename,String fileType,String description,
			String length,String width,String labourPrice,String manufacturePrice,String variant,String woodPrice, boolean isFeatured,byte[] display,Integer quantity) {
		super();
		this.id = id;
		this.productname = productname;
		this.price = price;
		this.woodPrice=woodPrice;
		this.manufacture = manufacture;
		this.stock = stock;
		this.image = image;
		this.WoodType_id = WoodType_id;
		this.woodtypename = woodtypename;
		this.fileType = fileType;
		this.description = description;
		this.width = width;
		this.length = length;
		this.labourPrice = labourPrice;
		this.manufacturePrice = manufacturePrice;
		this.variant = variant;
		this.isFeatured = isFeatured;
		this.display = display;
		this.quantity = quantity;
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
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getWoodType_id() {
		return WoodType_id;
	}
	public void setWoodType_id(Integer woodType_id) {
		WoodType_id = woodType_id;
	}
	public String getWoodtypename() {
		return woodtypename;
	}
	public void setWoodtypename(String woodtypename) {
		this.woodtypename = woodtypename;
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
	public void setWoodPrice(String woodPrice) {
		// TODO Auto-generated method stub
		this.woodPrice = woodPrice;
	}

}
