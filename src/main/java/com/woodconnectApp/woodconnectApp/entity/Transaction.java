package com.woodconnectApp.woodconnectApp.entity;

public class Transaction {
		private String orderId;
		public String getOrderId() {
			return orderId;
		}
		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}
		private String currency;
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		public Integer getAmount() {
			return amount;
		}
		public void setAmount(Integer amount) {
			this.amount = amount;
		}
		private Integer amount;
		
		public Transaction(String orderId,String currency,Integer amount) {
			this.orderId = orderId;
			this.currency = currency;
			this.amount = amount;
		}
	 
}
