package com.woodconnectApp.woodconnectApp.service.impl;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.woodconnectApp.woodconnectApp.dto.ProductDTO;
import com.woodconnectApp.woodconnectApp.dto.QuotationDTO;
import com.woodconnectApp.woodconnectApp.entity.Product;
import com.woodconnectApp.woodconnectApp.entity.Quotation;
import com.woodconnectApp.woodconnectApp.entity.User;
import com.woodconnectApp.woodconnectApp.entity.WoodType;
import com.woodconnectApp.woodconnectApp.repository.QuotationRepository;
import com.woodconnectApp.woodconnectApp.repository.UserRepository;
import com.woodconnectApp.woodconnectApp.repository.WoodTypeRepository;
import com.woodconnectApp.woodconnectApp.services.QuotationServices;

import jakarta.transaction.Transactional;
@Service
public class QuotationServiceImpl implements QuotationServices {
	@Autowired
	private QuotationRepository quotationRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private WoodTypeRepository woodTypeRepository;
	
	@Override
	public List getQuotation() {
		List<Quotation> quotations = quotationRepository.findAll();
		List<QuotationDTO> quotationDetails = new ArrayList<>();
		for (Quotation quotation : quotations) //to get multiple items
			{
			Optional<User> user = userRepository.findById(quotation.getUser().getId());
			QuotationDTO quotationObject = new QuotationDTO(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
			quotationObject.setId(quotation.getId());
			quotationObject.setUser_id(user.get().getId());
			quotationObject.setUsername(quotation.getCustomerName());
			quotationObject.setQuantity(quotation.getQuantity());
			quotationObject.setMobile(user.get().getPhone());
			quotationObject.setDescription(quotation.getDescription());
			quotationObject.setStatus(quotation.getStatus());
			quotationObject.setResponse(quotation.getResponse());
			quotationObject.setWoodTypeId(null);
			WoodType wood = woodTypeRepository.findById(quotation.getWoodTypeId())
					.orElseThrow(() -> new RuntimeException("QuotationId not found"));
			quotationObject.setWoodName(wood.getWoodname());
			quotationObject.setWoodTypeId(wood.getId());
			quotationObject.setWoodPrice(wood.getPrice());
			quotationObject.setProductName(quotation.getProductName());
			quotationObject.setDimensions(quotation.getDimension());
			quotationObject.setTotalPrice(quotation.getTotalPrice());
			quotationObject.setDiscount(quotation.getDiscount());
			quotationObject.setManufacturingCost(quotation.getManufacturingCost());
	quotationDetails.add(quotationObject);
		}
		return quotationDetails;
		}



	@Override
	public void createQuotation(String description, Integer user_id, byte[] imageBytes) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(user_id)
				.orElseThrow(() -> new RuntimeException("QuotationId not found"));
		Quotation quotationinfo = new Quotation();
		quotationinfo.setUser(user);
		quotationinfo.setDescription(description);
		quotationinfo.setStatus("Requested");
		quotationinfo.setImage(imageBytes);
		quotationRepository.save(quotationinfo);
	}



	
	public QuotationDTO getQuotationDetailsf(Integer id) {
		// TODO Auto-generated method stub
		Optional<Quotation> quotation = quotationRepository.findById(id);
			Optional<User> user = userRepository.findById(quotation.get().getUser().getId());
			QuotationDTO quotationObject = new QuotationDTO(null, null, null, null, null, null, null, null, null, null, id, null, null, null, null, null, null, null);
			quotationObject.setId(quotation.get().getId());
			quotationObject.setUser_id(user.get().getId());
			quotationObject.setUsername(quotation.get().getCustomerName());
			
			quotationObject.setMobile(user.get().getPhone());
			quotationObject.setDescription(quotation.get().getDescription());
			quotationObject.setQuantity(quotation.get().getQuantity());
			quotationObject.setStatus(quotation.get().getStatus());
			if(quotation.get().getImage()!=null) {
		    String base64Image = Base64.getEncoder().encodeToString(quotation.get().getImage());
	
		    quotationObject.setImage(base64Image);
	    }
			WoodType wood = woodTypeRepository.findById(quotation.get().getWoodTypeId())
					.orElseThrow(() -> new RuntimeException("QuotationId not found"));
			quotationObject.setWoodName(wood.getWoodname());
			quotationObject.setWoodTypeId(wood.getId());
			quotationObject.setResponse(quotation.get().getResponse());
			quotationObject.setWoodPrice(wood.getPrice());
			quotationObject.setProductName(quotation.get().getProductName());
			quotationObject.setDimensions(quotation.get().getDimension());
			quotationObject.setTotalPrice(quotation.get().getTotalPrice());
			quotationObject.setDiscount(quotation.get().getDiscount());
			quotationObject.setManufacturingCost(quotation.get().getManufacturingCost());
	
			return quotationObject;

	}



	@Override
	public void updateStatus(Integer id, QuotationDTO quotation) {
		Quotation quotationData =quotationRepository
		        .findById(id)
		        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
		quotationData.setResponse(quotation.getResponse());
		quotationData.setStatus(quotation.getStatus());
		if ("Accepted".equals(quotation.getStatus())) {
			quotationData.setProductName(quotation.getProductName());
			quotationData.setDimension(quotation.getDimensions());
			quotationData.setTotalPrice(quotation.getTotalPrice());
			quotationData.setDiscount(quotation.getDiscount());
			quotationData.setManufacturingCost(quotation.getManufacturingCost());
		}
		quotationRepository.save(quotationData);
	}


}
