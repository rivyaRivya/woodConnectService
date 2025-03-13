package com.woodconnectApp.woodconnectApp.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woodconnectApp.woodconnectApp.dto.TotalCount;
import com.woodconnectApp.woodconnectApp.dto.UserDTO;
import com.woodconnectApp.woodconnectApp.dto.WoodTypeDTO;
import com.woodconnectApp.woodconnectApp.entity.User;
import com.woodconnectApp.woodconnectApp.entity.WoodType;
import com.woodconnectApp.woodconnectApp.service.impl.UserServiceImpl;


@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class userController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	@Autowired
    private UserServiceImpl userServices;
	
	@PostMapping("/user")
    public String createBooking(@RequestBody UserDTO  userinfo) {
       System.out.print(userinfo);
        
         userServices.createUser(userinfo);
        return "User added successfully";
    }
	
	@PostMapping("/login")
	@ResponseBody
	public Integer login(@RequestBody UserDTO user) {
		Integer id = userServices.login(user);
		return	id;
	}
	 /**
     * get users as list
     */
	
	@GetMapping("/getUsers")
	public List<UserDTO> getUsers(){
		return userServices.getUser();
	}
	@GetMapping("/user-details")
    public UserDTO getuserdetails(@RequestParam Integer id) {
        return userServices.getUserDetail(id);
    }
	
//	 @PutMapping("/update-address/{id}")
//	    public ResponseEntity<Void> updateAddress(@PathVariable Integer id) {
//	    	userServices.updateAddress(id);
//	        return ResponseEntity.noContent().build();
//	    }
	 @DeleteMapping("delete-user/{id}")
	    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
	    	userServices.deleteUser(id);
	        return ResponseEntity.noContent().build();
	    }
	 @PutMapping("/update-user/{id}")
	    public ResponseEntity<Void> updateWoodType(@PathVariable Integer id, @RequestBody UserDTO user) {
		  System.out.print(user+"kkkkkkkkkkkkkkkkkk");
		  userServices.updateUser(id, user);

	        return ResponseEntity.noContent().build();
	    }
	 @GetMapping("/dashboard/counts")
	    public TotalCount getCounts() {
	        long totalCustomers = userServices.getTotalCustomerCount();
	        long deliveredOrders = userServices.getDeliveredOrderCount();
	        long totalOrder = userServices.getOrderCount();
	        long totalQuotation = userServices.getQuotationCount();
	        TotalCount count = new TotalCount();
	        count.setCustomer(totalCustomers);
	        count.setOrder(totalOrder);
	        count.setDeliveredOrder(deliveredOrders);
	        count.setQuotation(totalQuotation);
	        // Return both counts as a response
	        return count;
	    }
	 
	 @GetMapping("/getAvailableDriver")
		public List<UserDTO> getAvailableDriver(){
			return userServices.getAvailableDriver();
		}
	 
    }

