package com.woodconnectApp.woodconnectApp.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.woodconnectApp.woodconnectApp.dto.OrderDetailsDTO;
import com.woodconnectApp.woodconnectApp.dto.OrderRequest;
import com.woodconnectApp.woodconnectApp.dto.OrderTableDTO;
import com.woodconnectApp.woodconnectApp.dto.ProductDTO;
import com.woodconnectApp.woodconnectApp.entity.OrderDetails;
import com.woodconnectApp.woodconnectApp.entity.OrderTable;
import com.woodconnectApp.woodconnectApp.entity.Product;
import com.woodconnectApp.woodconnectApp.entity.User;
import com.woodconnectApp.woodconnectApp.entity.WoodType;
import com.woodconnectApp.woodconnectApp.repository.OrderDetailsRepository;
import com.woodconnectApp.woodconnectApp.repository.OrderTableRepository;
import com.woodconnectApp.woodconnectApp.repository.ProductRepository;
import com.woodconnectApp.woodconnectApp.repository.UserRepository;
import com.woodconnectApp.woodconnectApp.repository.WoodTypeRepository;
import com.woodconnectApp.woodconnectApp.services.OrderTableServices;

@Service
public class OrderTableServiceImpl implements OrderTableServices {
	@Autowired
	private OrderTableRepository orderTableRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
    private WoodTypeRepository woodTypeRepository;
	
//	@Override
//	public void createOrderTable(OrderTableDTO orderTableData) {
//		User user = userRepository.findById(orderTableData.getId())
//				.orElseThrow(() -> new RuntimeException("User_Id not found"));
//		OrderTable orderTableinfo = new OrderTable();
//		orderTableinfo.setUser(user);
//		orderTableinfo.setStatus(orderTableData.getStatus());
//		orderTableinfo.setOrderDate(orderTableData.getOrderDate());
//		orderTableinfo.setAdvanced_amount(orderTableData.getAdvanced_amount());
//		orderTableinfo.setTotal_amount(orderTableData.getTotal_amount());
//		orderTableinfo.setDelivery_date(orderTableData.getDelivery_date());
//		orderTableRepository.save(orderTableinfo);
//		return;
//		
//	}
	
	public void updateOrderTableStatus(Integer id) {
		OrderTable orderTable =orderTableRepository
        .findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
		
        orderTable.setStatus("Confirmed");
		orderTableRepository.save(orderTable);
		System.out.print("done");
	}

	@Override
	public void updateDriver(Integer id, Integer driver_id, String deliverydate) {
		System.out.print("ddddddddddddddddddddddddddddd"+driver_id);
		// TODO Auto-generated method stub
		OrderTable orderTable1 =orderTableRepository
		        .findById(id)
		        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
		
		if(deliverydate != null) {
			orderTable1.setDelivery_date(deliverydate);
		}
		if(driver_id != null) {
			User driver = userRepository.findById(driver_id).get();
			orderTable1.setDriver(driver);
			LocalDate currentDate = LocalDate.now();
	        orderTable1.setStatus("Ready for departure");
	        // Formatting the current date to a string (e.g., "2025-03-09")
	        String formattedDate = currentDate.format(DateTimeFormatter.ISO_DATE);
	        
			orderTable1.setAssign_date(formattedDate);
		
		}
		orderTableRepository.save(orderTable1);
	}
//
//	public void createOrderTable(OrderTableDTO ordertableinfo) {
//		// TODO Auto-generated method stub
//		
//	}

public Integer createOrderTable(OrderTable order, OrderDetails orderDetailsObj, OrderRequest orderRequest) {
    OrderDetails orderDetails = new OrderDetails();

    // Fetch user details
    User user = userRepository.findById(orderRequest.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found"));
    order.setUser(user);

    // Check for an existing pending order
    List<OrderTable> savedOrders = orderTableRepository.findPendingOrder(orderRequest.getUserId(), "pending");

    if (savedOrders.isEmpty()) {
        // No pending order, create a new one
        order.setTotal_amount(Double.parseDouble(orderDetailsObj.getProduct().getPrice()) * orderDetailsObj.getQuantity());
        OrderTable savedOrder = orderTableRepository.save(order);

        orderDetailsObj.setOrderTable(savedOrder);
        orderDetails = orderDetailsRepository.save(orderDetailsObj);
    } else {
        // Pending order exists, update it
        OrderTable existingOrder = savedOrders.get(0); // Get the first pending order
        List<OrderDetails> orderDetailsList = orderDetailsRepository.findByorderTable_id(existingOrder.getId());

        boolean productExists = false;

        for (OrderDetails existingDetail : orderDetailsList) {
            if (existingDetail.getProduct().getId().equals(orderDetailsObj.getProduct().getId())) {
                if ("remove".equals(orderRequest.getType())) {
                    // Remove product and update total amount
                    existingOrder.setTotal_amount(existingOrder.getTotal_amount() -
                            Double.parseDouble(existingDetail.getProduct().getPrice()) * existingDetail.getQuantity());

                    orderDetailsRepository.delete(existingDetail);
                } else {
                    // Update quantity based on type
                    int quantity = existingDetail.getQuantity();
                    if ("inc".equals(orderRequest.getType())) {
                        quantity += orderDetailsObj.getQuantity();
                    } else if ("dec".equals(orderRequest.getType())) {
                        quantity -= orderDetailsObj.getQuantity();
                    }

                    if (quantity <= 0) {
                        // If quantity reaches 0, remove product
                        existingOrder.setTotal_amount(existingOrder.getTotal_amount() -
                                Double.parseDouble(existingDetail.getProduct().getPrice()) * existingDetail.getQuantity());
                        orderDetailsRepository.delete(existingDetail);
                    } else {
                        existingDetail.setQuantity(quantity);
                        existingOrder.setTotal_amount(existingOrder.getTotal_amount() +
                                Double.parseDouble(orderDetailsObj.getProduct().getPrice()) * orderDetailsObj.getQuantity());

                        orderDetails = orderDetailsRepository.save(existingDetail);
                    }
                }
                productExists = true;
                break;
            }
        }

        if (!productExists && !"remove".equals(orderRequest.getType())) {
            // Add new product if it's not a removal operation
            existingOrder.setTotal_amount(existingOrder.getTotal_amount() +
                    Double.parseDouble(orderDetailsObj.getProduct().getPrice()) * orderDetailsObj.getQuantity());

            orderDetailsObj.setOrderTable(existingOrder);
            orderDetails = orderDetailsRepository.save(orderDetailsObj);
        }

        // Delete order if there are no remaining items
        if (orderDetailsRepository.findByorderTable_id(existingOrder.getId()).isEmpty()) {
            orderTableRepository.delete(existingOrder);
        } else {
            orderTableRepository.save(existingOrder);
        }
    }

    return orderDetails.getId();
}



	public List<OrderTableDTO> getOrders() {
		List<OrderTable> orders = orderTableRepository.findAll();
		List<OrderTableDTO> orderList = new ArrayList<>();
		for (OrderTable order : orders) //to get multiple items
			{	
				OrderTableDTO orderObject = new OrderTableDTO(null, null, null, null, null, null, null, null,null, null, null, null);
				orderObject.setAdvanced_amount(order.getAdvanced_amount());
				orderObject.setAssign_date(order.getAssign_date());
				orderObject.setDelivery_date(order.getDelivery_date());
				orderObject.setId(order.getId());
				orderObject.setOrderDate(order.getOrderDate());
				orderObject.setStatus(order.getStatus());
				orderObject.setTotal_amount(order.getTotal_amount());
				orderObject.setPaymentStatus(order.getPaymentStatus());
				if(order.getUser() != null) {
					Optional<User> user = userRepository.findById(order.getUser().getId());
					orderObject.setUserId(user.get().getId());
					orderObject.setUsername(user.get().getFirstname() + " " +user.get().getLastname());
				}
				if(order.getDriver() != null) {
					Optional<User> driver = userRepository.findById(order.getDriver().getId());
					orderObject.setDriverId(driver.get().getId());
					orderObject.setDriverName(driver.get().getFirstname() + " " +driver.get().getLastname());
				}
			    orderList.add(orderObject);
			}
		return orderList;
	}

	public OrderDetailsDTO getOrderDetails(Integer id) {
		 OrderTable order = orderTableRepository
	                .findById(id)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid order Id:" + id));
	     List<OrderDetails> orderDetails = orderDetailsRepository
	                .findByorderTable_id(id);
	     OrderTableDTO orderData = new OrderTableDTO(id, null, null, null, null, null, null, id, null, id, null, null);
	     orderData.setAdvanced_amount(order.getAdvanced_amount());
	     orderData.setAssign_date(order.getAssign_date());
	     orderData.setDelivery_date(order.getDelivery_date());
	     orderData.setId(order.getId());
	     orderData.setOrderDate(order.getOrderDate());
	     orderData.setPaymentStatus(order.getPaymentStatus());
	     orderData.setStatus(order.getStatus());
	     orderData.setTotal_amount(order.getTotal_amount());
	     if(order.getUser() != null) {
				Optional<User> user = userRepository.findById(order.getUser().getId());
				orderData.setUserId(user.get().getId());
				orderData.setUsername(user.get().getFirstname() + " " +user.get().getLastname());
			}
			if(order.getDriver() != null) {
				Optional<User> driver = userRepository.findById(order.getDriver().getId());
				orderData.setDriverId(driver.get().getId());
				orderData.setDriverName(driver.get().getFirstname() + " " +driver.get().getLastname());
			}
	     OrderDetailsDTO orderDetailsList = new OrderDetailsDTO(id, null, null);
	     List<ProductDTO> productDetails = new ArrayList<>();
	     for (OrderDetails orderDetail : orderDetails) //to get multiple items
			{	
	    	 	Optional<Product> product = productRepository.findById(orderDetail.getProduct().getId());
				ProductDTO productObject = new ProductDTO(id, null, null, null, null, null, id, null, null, null, null, null, null, null, null, null, false, null, null, null);
				productObject.setId(product.get().getId());
				productObject.setManufacture(product.get().getManufacturedate());
				productObject.setPrice(product.get().getPrice());
				productObject.setStock(product.get().getStock());
				productObject.setProductname(product.get().getProductname());
				productObject.setQuantity(orderDetail.getQuantity());
				if(product.get().getWoodType() != null) {
					Optional<WoodType> wood = woodTypeRepository.findById(product.get().getWoodType().getId());
					productObject.setWoodtypename(wood.get().getWoodname());
				}
				if(product.get().getImage()!=null) {
				    String base64Image = Base64.getEncoder().encodeToString(product.get().getImage());
			
				    productObject.setImage(base64Image);
			    }
				
				productDetails.add(productObject);
			}
	     orderDetailsList.setId(id);
	     orderDetailsList.setProduct(productDetails);
	     orderDetailsList.setOrder(orderData);
		return orderDetailsList;
	}

	@Override
	public void updateStatus(Integer id, OrderTableDTO orderTable) {
		// TODO Auto-generated method stub
		
	}

	public Integer getOrderId(Integer id) {
	    List<OrderTable> savedOrders = orderTableRepository.findPendingOrder(id, "pending");
	    if (!savedOrders.isEmpty()) {
	    	OrderTable existingOrder = savedOrders.get(0); // Get the first pending order
	    	return existingOrder.getId();
	    }else
	    	return 0;
	}
	

    public Integer getOrderCount(Integer id) {
    	return orderDetailsRepository.getTotalCartCountByUserId(id);
    }

	public void updateStatus(Integer id, String status) {
		OrderTable orderTable =orderTableRepository
		        .findById(id)
		        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
				
    orderTable.setStatus(status);
	orderTableRepository.save(orderTable);
		
	}


}
