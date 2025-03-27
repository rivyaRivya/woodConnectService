package com.woodconnectApp.woodconnectApp.controller;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woodconnectApp.woodconnectApp.dto.TotalCount;
import com.woodconnectApp.woodconnectApp.dto.UserDTO;
import com.woodconnectApp.woodconnectApp.dto.WoodTypeDTO;
import com.woodconnectApp.woodconnectApp.entity.User;
import com.woodconnectApp.woodconnectApp.entity.WoodType;
import com.woodconnectApp.woodconnectApp.repository.OrderDetailsRepository;
import com.woodconnectApp.woodconnectApp.service.impl.OrderTableServiceImpl;
import com.woodconnectApp.woodconnectApp.service.impl.UserServiceImpl;


@RestController
@CrossOrigin(origins = "http://localhost:3000,http://localhost:8081", maxAge = 3600)
public class userController {

    private final OrderTableServiceImpl orderTableServiceImpl;

    userController(OrderTableServiceImpl orderTableServiceImpl) {
        this.orderTableServiceImpl = orderTableServiceImpl;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	@Autowired
    private UserServiceImpl userServices;
	

	@Autowired
    private OrderTableServiceImpl orderService;
	
	@PostMapping("/user")
    public String createBooking(
            @RequestParam("firstname") String firstname,
            @RequestParam(name="lastname", required = false) String lastname,
            @RequestParam(name="address", required = false) String address,
            @RequestParam("email") String email,
            @RequestParam(name="dob", required = false) String dob,
            @RequestParam("phone") String phone,
            @RequestParam(name="gender", required = false) String gender, 
            @RequestParam(name="pin", required = false) String pin,
            @RequestParam(name="district", required = false) String district,
            @RequestParam("type") String type,
            @RequestParam("password") String password,
            @RequestParam(name="file", required = false) MultipartFile file) throws IOException {
        
         userServices.createUser(firstname,lastname,address,email,dob,phone,gender,pin,district,type,password,file);
        return "User added successfully";
    }
	
	@PostMapping("/login")
	@ResponseBody
	public UserDTO login(@RequestBody UserDTO user) {
		UserDTO userData = userServices.login(user);
		return	userData;
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
	 
	 @GetMapping("/counts/{id}")
	 public long getCount(@PathVariable Integer id){
	        long customerCart = orderService.getOrderCount(id);
	        return customerCart;
	    }
	 
	 @GetMapping("/getAvailableDriver")
		public List<UserDTO> getAvailableDriver(){
			return userServices.getAvailableDriver();
		}
	 
    }

