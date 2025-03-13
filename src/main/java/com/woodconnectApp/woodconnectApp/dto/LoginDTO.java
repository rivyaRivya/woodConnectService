package com.woodconnectApp.woodconnectApp.dto;

import lombok.Data;

@Data
public class LoginDTO {
	private Integer id;
	private String username;
	private String password;
	public LoginDTO(Integer id,String username,String password){
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

}
