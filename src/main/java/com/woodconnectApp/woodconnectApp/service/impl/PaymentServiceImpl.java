package com.woodconnectApp.woodconnectApp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.transport.transport.dto.BookingDTO;
import com.transport.transport.entity.Booking;
import com.transport.transport.entity.Driver;
import com.transport.transport.entity.TouristPlace;
import com.woodconnectApp.woodconnectApp.dto.PaymentDTO;
import com.woodconnectApp.woodconnectApp.dto.ProductDTO;
import com.woodconnectApp.woodconnectApp.entity.OrderTable;
import com.woodconnectApp.woodconnectApp.entity.Payment;
import com.woodconnectApp.woodconnectApp.entity.Product;
import com.woodconnectApp.woodconnectApp.entity.Review;
import com.woodconnectApp.woodconnectApp.entity.WoodType;
import com.woodconnectApp.woodconnectApp.repository.OrderTableRepository;
import com.woodconnectApp.woodconnectApp.repository.PaymentRepository;
import com.woodconnectApp.woodconnectApp.repository.ProductRepository;
import com.woodconnectApp.woodconnectApp.services.PaymentServices;
@Service
public class PaymentServiceImpl implements PaymentServices {
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private OrderTableRepository orderTableRepository;
	

	@Override
	public Integer createPayment(PaymentDTO paymentData) {
		OrderTable orderTable = orderTableRepository.findById(paymentData.getOrder_id())
				.orElseThrow(() -> new RuntimeException("OrderTableId not found"));
		Payment paymentinfo = new Payment();
		paymentinfo.setOrder(orderTable);
		paymentinfo.setPayment_status(paymentData.getPayment_status());
		paymentinfo.setPayment_amount(paymentData.getPayment_amount());
		paymentinfo.setDate(paymentData.getDate());
		paymentRepository.save(paymentinfo);
		return null;
	}
		
		
		@Override
		public List  getPayment() {
			List<Payment> payments = paymentRepository.findAll();
			List<PaymentDTO> paymentDetails = new ArrayList<>();
			for (Payment payment : payments) //to get multiple items
				{
				Optional<OrderTable> order = orderTableRepository.findById(payment.getOrder().getId());
			    PaymentDTO paymentObject = new PaymentDTO(null,null,null,null,null);
			    paymentObject.setId(payment.getId());
			    paymentObject.setId(order.get().getId());
			    paymentObject.setPayment_status(payment.getPayment_status());
			    paymentObject.setPayment_amount(payment.getPayment_amount());
			    paymentObject.setDate(payment.getDate());
			    paymentDetails.add(paymentObject);
			}
			return paymentDetails;
		
		}
		public void updatePaymentStatus(Integer id) {
			Payment payment =paymentRepository
	        .findById(id)
	        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
			payment.setPayment_status("Conformed");
			paymentRepository.save(payment);
			System.out.print("done");
		}


			@Override
			public void updatePayment(Integer id, PaymentDTO payment) {
				// TODO Auto-generated method stub
				
			}
	}


