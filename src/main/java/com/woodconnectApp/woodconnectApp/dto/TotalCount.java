package com.woodconnectApp.woodconnectApp.dto;

import lombok.Data;

@Data
public class TotalCount {

	private Long order;
	private Long customer;
	private Long deliveredOrder;
	private Long quotation;
	private Long cart;
	public Long getOrder() {
		return order;
	}
	public void setOrder(Long order) {
		this.order = order;
	}
	public Long getCustomer() {
		return customer;
	}
	public void setCustomer(Long customer) {
		this.customer = customer;
	}
	public Long getDeliveredOrder() {
		return deliveredOrder;
	}
	public void setDeliveredOrder(Long deliveredOrder) {
		this.deliveredOrder = deliveredOrder;
	}
	public Long getQuotation() {
		return quotation;
	}
	public void setQuotation(Long quotation) {
		this.quotation = quotation;
	}
	public void TotalCountDTO(Long order,Long customer,Long deliveredOrder,Long quotation,Long cart) {
		
		this.deliveredOrder = deliveredOrder;
		this.customer = customer;
		this.order = order;
		this.quotation = quotation;
		this.cart = cart;
	}
}
