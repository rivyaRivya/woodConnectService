package com.woodconnectApp.woodconnectApp.dto;

import lombok.Data;

@Data
public class WoodTypeDTO {
	private Integer id;
	private String woodname;
	private String price;
	public WoodTypeDTO(Integer id,String woodname,String price){
		super();
		this.id = id;
		this.woodname = woodname;
		this.price = price;
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
