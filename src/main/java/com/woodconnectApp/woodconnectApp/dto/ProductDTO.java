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
	public ProductDTO(Integer id,String productname,String price,
			String manufacture,String stock,String image,Integer WoodType_id,String woodtypename,String fileType,String description,
			String length,String width,String labourPrice,String manufacturePrice) {
		super();
		this.id = id;
		this.productname = productname;
		this.price = price;
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
	}

}
