package com.woodconnectApp.woodconnectApp.services;

import java.util.List;

import com.woodconnectApp.woodconnectApp.dto.PaymentDTO;


public interface PaymentServices {
	Integer createPayment(PaymentDTO paymentData);
	List<PaymentDTO> getPayment();
	
	void updatePayment(Integer id, PaymentDTO payment);


}
