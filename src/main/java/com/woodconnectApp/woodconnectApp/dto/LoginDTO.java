package com.woodconnectApp.woodconnectApp.dto;

import lombok.Data;

@Data
public class LoginDTO {
	private Integer id;
	private String username;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
	public LoginDTO(Integer id,String username,String password){
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

}
