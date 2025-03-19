package com.woodconnectApp.woodconnectApp.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.woodconnectApp.woodconnectApp.dto.OrderDetailsDTO;
import com.woodconnectApp.woodconnectApp.dto.OrderRequest;
import com.woodconnectApp.woodconnectApp.dto.OrderTableDTO;
import com.woodconnectApp.woodconnectApp.entity.OrderDetails;
import com.woodconnectApp.woodconnectApp.entity.OrderTable;
import com.woodconnectApp.woodconnectApp.entity.Product;
import com.woodconnectApp.woodconnectApp.entity.User;
import com.woodconnectApp.woodconnectApp.repository.ProductRepository;
import com.woodconnectApp.woodconnectApp.repository.UserRepository;
import com.woodconnectApp.woodconnectApp.service.impl.OrderTableServiceImpl;


@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class orderTableController {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	@Autowired
    private OrderTableServiceImpl orderTableServices;
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/create-order")
    public String createOrderTable(@RequestBody OrderRequest  orderRequest) {
       OrderTable order = new OrderTable();
       order.setAdvanced_amount(orderRequest.getAdvanced_amount());
       order.setTotal_amount(orderRequest.getTotalAmount());
       order.setStatus(orderRequest.getOrderStatus());
       order.setOrderDate(orderRequest.getOrderDate());
       order.setPaymentStatus("pending");
       User user =  userRepository.findById(orderRequest.getUserId()).get();
       order.setUser(user);
       
       List<OrderDetails> orderDetailsList = orderRequest.getProducts().stream()
               .map(productRequest -> {
                   Product product = productRepository.findById(productRequest.getProductId()).get();
                   OrderDetails orderDetails = new OrderDetails();                   
                   orderDetails.setOrderTable(order); // Set the order reference
                   orderDetails.setProduct(product); // Set the product reference
                   return orderDetails;
               })
               .toList();
         orderTableServices.createOrderTable(order,orderDetailsList);
        return "OrderTable added successfully";
    }
	
	@PutMapping("/update-orderTable/{id}")
	public ResponseEntity<Void> updateOrderTableStatus(@PathVariable Integer id, @RequestParam("driver_id") Integer driver_id, @RequestParam("deliverydate") String deliverydate) {
    	
		orderTableServices.updateDriver(id,driver_id,deliverydate);
        return ResponseEntity.noContent().build();
    }
	
	@GetMapping("/get-orders")
	public ResponseEntity<List<OrderTableDTO>> getOders(){
		return ResponseEntity.ok(orderTableServices.getOrders());
	} 
	
	@GetMapping("/get-orderDetails")
    public OrderDetailsDTO getorderDetails(@RequestParam Integer id) {
        return orderTableServices.getOrderDetails(id);
    }
	
	  
}
