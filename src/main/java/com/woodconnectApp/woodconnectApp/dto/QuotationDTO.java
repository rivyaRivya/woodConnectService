package com.woodconnectApp.woodconnectApp.dto;

import java.sql.Blob;

import lombok.Data;

@Data
public class QuotationDTO {
	private Integer id;
	private String description;
	private String status;
	private String image;
	private Integer user_id;
	private String response;
	private String username;
	private String mobile;
	private String email;
	public QuotationDTO(Integer id,String description,String status,String image,
			Integer user_id,String username,String response,String mobile,String email){
		super();
		this.id = id;
		this.description = description;
		this.status = status;
		this.image = image;
		this.user_id = user_id;
		this.username = username;
		this.response = response;
		this.mobile = mobile;
		this.email = email;
	}

}
