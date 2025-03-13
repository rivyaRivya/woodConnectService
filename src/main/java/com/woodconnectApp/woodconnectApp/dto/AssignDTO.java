package com.woodconnectApp.woodconnectApp.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class AssignDTO {
	private Integer id;
	private String assign_date;
	private Integer user_id;
	private Integer Order_id;
	public AssignDTO(Integer id,String assign_date,Integer user_id,Integer Order_id) {
		super();
		this.id = id;
		this.assign_date = assign_date;
		this.user_id = user_id;
		this.Order_id = Order_id;
	}

}
