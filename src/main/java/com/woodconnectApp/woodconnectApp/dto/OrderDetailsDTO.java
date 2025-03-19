package com.woodconnectApp.woodconnectApp.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderDetailsDTO {
	private Integer id;
	private OrderTableDTO order;
	private List<ProductDTO> product;
	public OrderDetailsDTO(Integer id,OrderTableDTO order,ProductDTO product) {
		super();
		this.id = id;
		this.order = order;
		this.product = (List<ProductDTO>) product;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public OrderTableDTO getOrder() {
		return order;
	}
	public void setOrder(OrderTableDTO order) {
		this.order = order;
	}
	public List<ProductDTO> getProduct() {
		return product;
	}
	public void setProduct(List<ProductDTO> product) {
		this.product = product;
	}

}
