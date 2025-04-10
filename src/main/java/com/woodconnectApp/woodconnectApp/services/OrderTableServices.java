package com.woodconnectApp.woodconnectApp.services;

import com.woodconnectApp.woodconnectApp.dto.OrderTableDTO;
import com.woodconnectApp.woodconnectApp.entity.Transaction;


public interface OrderTableServices {
	
	
	void updateStatus(Integer id, OrderTableDTO orderTable);


	void updateDriver(Integer id, Integer driver_id, String deliverydate);


	Transaction createTransaction(Double amount);
	

//	void createOrderTable(OrderTableDTO orderTableData);

}
