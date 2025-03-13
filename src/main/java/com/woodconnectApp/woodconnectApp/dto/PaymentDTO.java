package com.woodconnectApp.woodconnectApp.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class PaymentDTO {
	private Integer id;
	private String payment_status;
	private String payment_amount;
	private Date date;
	private Integer order_id;
	public PaymentDTO(Integer id,String payment_status,String payment_amount,
			Date date,Integer order_id){
		super();
		this.id = id;
		this.payment_status = payment_status;
		this.payment_amount = payment_amount;
		this.date = date;
		this.order_id = order_id;
	}

}
