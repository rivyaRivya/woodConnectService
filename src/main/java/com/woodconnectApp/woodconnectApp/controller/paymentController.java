package com.woodconnectApp.woodconnectApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.woodconnectApp.woodconnectApp.dto.PaymentDTO;
import com.woodconnectApp.woodconnectApp.dto.ProductDTO;
import com.woodconnectApp.woodconnectApp.service.impl.PaymentServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class paymentController {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	@Autowired
    private PaymentServiceImpl paymentServices;
	
	@PostMapping("/payment")
    public String createPayment(@RequestBody PaymentDTO  paymentinfo) {
       System.out.print(paymentinfo);
        
         paymentServices.createPayment(paymentinfo);
        return "Payment added successfully";
    }
	
	
	 @GetMapping("/get-payment")
	    public ResponseEntity<List<PaymentDTO>> getPayment() {
	        return ResponseEntity.ok(paymentServices.getPayment());
	    }
	 
	 @PutMapping("/update-payment/{id}")
	    public ResponseEntity<Void> updatePaymentStatus(@PathVariable Integer id,@RequestBody PaymentDTO payment) {
	    	paymentServices.updatePayment(id,payment);
	        return ResponseEntity.noContent().build();
	    }

}
