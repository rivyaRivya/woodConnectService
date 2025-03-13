package com.woodconnectApp.woodconnectApp.services;

import com.woodconnectApp.woodconnectApp.dto.OrderTableDTO;


public interface OrderTableServices {
	
	
	void updateStatus(Integer id, OrderTableDTO orderTable);


	void updateDriver(Integer id, Integer driver_id, String deliverydate);
	

//	void createOrderTable(OrderTableDTO orderTableData);

}
