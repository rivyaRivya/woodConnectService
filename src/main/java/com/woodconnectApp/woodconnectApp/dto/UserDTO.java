package com.woodconnectApp.woodconnectApp.dto;

import lombok.Data;

@Data
public class UserDTO {
	private Integer id;
	private String firstname;
	private String lastname;
	private String dob;
	private String username;
	private String phone;
	private String gender;
	private String address;
	private String pin;
	private String district;
	private String type;
	private String password;
	public UserDTO(Integer id,String firstname,String lastname,String dob,String email,
			String phone,String gender,String address,String pin,String district,
			String type,String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.username = email;
		this.phone = phone;
		this.gender = gender;
		this.address = address;
		this.pin = pin;
		this.district = district;
		this.type = type;
		this.password = password;
	}

}
