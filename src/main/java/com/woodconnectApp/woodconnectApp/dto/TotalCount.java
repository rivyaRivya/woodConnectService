package com.woodconnectApp.woodconnectApp.dto;

import lombok.Data;

@Data
public class TotalCount {

	private Long order;
	private Long customer;
	private Long deliveredOrder;
	private Long quotation;
	public void TotalCountDTO(Long order,Long customer,Long deliveredOrder,Long quotation) {
		
		this.deliveredOrder = deliveredOrder;
		this.customer = customer;
		this.order = order;
		this.quotation = quotation;
	}
}
