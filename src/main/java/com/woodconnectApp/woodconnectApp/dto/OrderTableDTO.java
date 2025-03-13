package com.woodconnectApp.woodconnectApp.dto;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class OrderTableDTO {
	private Integer id;
	private String status;
	private String orderDate;
	private Double advanced_amount;
	private Double total_amount;
	private String delivery_date;
	private String assign_date;
	private List<ProductDTO> products;
	private Integer userId;
	private String username;
	private Integer driverId;
	private String driverName;
	private String paymentStatus;
	
	public OrderTableDTO(Integer id,String status,String orderDate,Double advanced_amount,
			Double total_amount,String delivery_date,String assign_date,Integer userId,String username,
			Integer driverId,String driverName,String paymentStatus){
		super();
		this.id = id;
		this.status = status;
		this.orderDate = orderDate;
		this.advanced_amount = advanced_amount;
		this.total_amount = total_amount;
		this.delivery_date = delivery_date;
		this.assign_date = assign_date;
		this.userId = userId;
		this.username = username;
		this.driverId = driverId;
		this.driverName= driverName;
		this.paymentStatus = paymentStatus;
	}
	
	public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
