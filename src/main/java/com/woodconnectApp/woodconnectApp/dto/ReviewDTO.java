package com.woodconnectApp.woodconnectApp.dto;

import lombok.Data;

@Data
public class ReviewDTO {
	private Integer id;
	private String rating;
	private String review;
	private String username;
	private Integer user_id;
	private Integer product_id;
	private String productname;
	
	public ReviewDTO(Integer id,String rating,String review,String username,Integer user_id,Integer product_id,String productname) {
		super();
		this.id = id;
		this.rating = rating;
		this.review = review;
		this.username = username;
		this.user_id = user_id;
		this.product_id = product_id;
		this.productname = productname;
	}
	

}
