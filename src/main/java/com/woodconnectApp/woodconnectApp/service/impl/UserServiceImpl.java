package com.woodconnectApp.woodconnectApp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.woodconnectApp.woodconnectApp.dto.UserDTO;
import com.woodconnectApp.woodconnectApp.dto.WoodTypeDTO;
import com.woodconnectApp.woodconnectApp.entity.User;
import com.woodconnectApp.woodconnectApp.entity.WoodType;
import com.woodconnectApp.woodconnectApp.repository.OrderTableRepository;
import com.woodconnectApp.woodconnectApp.repository.QuotationRepository;
import com.woodconnectApp.woodconnectApp.repository.UserRepository;
import com.woodconnectApp.woodconnectApp.services.UserServices;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserRepository userRepositiry;
	@Autowired
	private OrderTableRepository orderRepositiry;
	@Autowired
	private QuotationRepository quotationRepositiry;
	@Override
	public Integer createUser(UserDTO userData) {
		User userinfo = new User();//create new user object
		userinfo.setAddress(userData.getAddress());
		userinfo.setDistrict(userData.getDistrict());
		userinfo.setDob(userData.getDob());
		userinfo.setEmail(userData.getUsername());
		userinfo.setFirstname(userData.getFirstname());
		userinfo.setLastname(userData.getLastname());
		userinfo.setGender(userData.getGender());
		userinfo.setPhone(userData.getPhone());
		userinfo.setPassword(userData.getPassword());
		userinfo.setPin(userData.getPin());
		userinfo.setType(userData.getType());
		userRepositiry.save(userinfo);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer login(UserDTO user) {
		User userData = userRepositiry.findByEmail(user.getUsername())
	            .orElseThrow(() -> new RuntimeException("not found"));
		return userData.getId();
	}

	public List<UserDTO> getUser() {
		// TODO Auto-generated method stub
		return userRepositiry.findAll().stream()
		        .map(driver -> new UserDTO(driver.getId(), driver.getFirstname(),
		        		driver.getLastname(),driver.getDob(),driver.getEmail(),driver.getPhone(),
		        		driver.getGender(),driver.getAddress(),driver.getPin(),driver.getDistrict(),driver.getType(), null))
		        .collect(Collectors.toList());
	}
	@Override
	public void deleteUser(Integer id) {
		User user = userRepositiry
                .findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));

		userRepositiry.delete(user);
	}
	@Override
	public void updateUser(Integer id, UserDTO userData) {
		User userinfo =userRepositiry
        .findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
		userinfo.setAddress(userData.getAddress());
		userinfo.setDistrict(userData.getDistrict());
		userinfo.setDob(userData.getDob());
		userinfo.setFirstname(userData.getFirstname());
		userinfo.setLastname(userData.getLastname());
		userinfo.setGender(userData.getGender());
		userinfo.setPhone(userData.getPhone());
		userinfo.setPin(userData.getPin());
		userRepositiry.save(userinfo);
	}
	@Override
	public UserDTO getUserDetail(Integer id) {
		User userData = userRepositiry
	                .findById(id)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
		UserDTO userinfo = new UserDTO(id, null, null, null, null, null, null, null, null, null, null, null);
		userinfo.setAddress(userData.getAddress());
		userinfo.setDistrict(userData.getDistrict());
		userinfo.setDob(userData.getDob());
		userinfo.setUsername(userData.getEmail());
		userinfo.setFirstname(userData.getFirstname());
		userinfo.setLastname(userData.getLastname());
		userinfo.setGender(userData.getGender());
		userinfo.setPhone(userData.getPhone());
		userinfo.setPin(userData.getPin());
		userinfo.setType(userData.getType());    
		
		return userinfo;
	}

	 public long getTotalCustomerCount() {
	        return userRepositiry.countOrdersWithCustomer();
	    }
	 
	 public long getDeliveredOrderCount() {
	        return orderRepositiry.countOrdersWithDeliveredStatus();
	    }
	 public long getOrderCount() {
	        return orderRepositiry.count();
	    }
	 public long getQuotationCount() {
	        return quotationRepositiry.count();
	    }

	public List<UserDTO> getAvailableDriver() {
//		return null;
		// TODO Auto-generated method stub
		List<User> user = orderRepositiry.findDriversNotInDeliveredBookings();
		List<UserDTO> userDetails = new ArrayList<>();
    	for (User userData : user) {
    		System.out.print(userData);
    		UserDTO userObject = new UserDTO(null, null, null, null, null, null, null, null, null, null, null, null);
    		userObject.setAddress(userData.getAddress());
    		userObject.setFirstname(userData.getFirstname());
    		userDetails.add(userObject);
    	}
		return userDetails;
	}
}
