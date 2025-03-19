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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
