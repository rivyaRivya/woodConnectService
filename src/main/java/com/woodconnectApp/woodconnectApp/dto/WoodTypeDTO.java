package com.woodconnectApp.woodconnectApp.dto;

import lombok.Data;

@Data
public class WoodTypeDTO {
	private Integer id;
	private String woodname;
	private String price;

	private byte[] image;
	public WoodTypeDTO(Integer id,String woodname,String price,byte[] bs){
		super();
		this.id = id;
		this.woodname = woodname;
		this.price = price;
		this.image = bs;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWoodname() {
		return woodname;
	}
	public void setWoodname(String woodname) {
		this.woodname = woodname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
