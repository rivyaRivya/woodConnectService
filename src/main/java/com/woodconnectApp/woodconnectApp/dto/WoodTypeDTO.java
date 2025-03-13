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

}
