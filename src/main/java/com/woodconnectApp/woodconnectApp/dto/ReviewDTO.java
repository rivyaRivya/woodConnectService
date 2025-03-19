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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}
	

}
