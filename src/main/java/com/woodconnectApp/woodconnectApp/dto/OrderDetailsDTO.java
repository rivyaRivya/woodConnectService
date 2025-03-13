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

}
