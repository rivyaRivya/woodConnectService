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
	private byte[] file;
	public UserDTO(Integer id,String firstname,String lastname,String dob,String email,
			String phone,String gender,String address,String pin,String district,
			String type,String password,byte[] file) {
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

		this.file = file;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
