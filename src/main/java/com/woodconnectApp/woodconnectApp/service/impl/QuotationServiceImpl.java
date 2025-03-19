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
import com.woodconnectApp.woodconnectApp.services.QuotationServices;

import jakarta.transaction.Transactional;
@Service
public class QuotationServiceImpl implements QuotationServices {
	@Autowired
	private QuotationRepository quotationRepository;
	@Autowired
	private UserRepository userRepository;
	@Override
	public List getQuotation() {
		List<Quotation> quotations = quotationRepository.findAll();
		List<QuotationDTO> quotationDetails = new ArrayList<>();
		for (Quotation quotation : quotations) //to get multiple items
			{
			Optional<User> user = userRepository.findById(quotation.getUser().getId());
			QuotationDTO quotationObject = new QuotationDTO(null, null, null, null, null, null, null, null, null);
			quotationObject.setId(quotation.getId());
			quotationObject.setUser_id(user.get().getId());
			quotationObject.setUsername(user.get().getFirstname()+ " " + user.get().getLastname());
			quotationObject.setEmail(user.get().getEmail());
			quotationObject.setMobile(user.get().getPhone());
			quotationObject.setDescription(quotation.getDescription());
			quotationObject.setStatus(quotation.getStatus());
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
			QuotationDTO quotationObject = new QuotationDTO(null, null, null, null, null, null, null, null, null);
			quotationObject.setId(quotation.get().getId());
			quotationObject.setUser_id(user.get().getId());
			quotationObject.setUsername(user.get().getFirstname()+ " " + user.get().getLastname());
			quotationObject.setEmail(user.get().getEmail());
			quotationObject.setMobile(user.get().getPhone());
			quotationObject.setDescription(quotation.get().getDescription());
			quotationObject.setStatus(quotation.get().getStatus());
			if(quotation.get().getImage()!=null) {
		    String base64Image = Base64.getEncoder().encodeToString(quotation.get().getImage());
	
		    quotationObject.setImage(base64Image);
	    }
			quotationObject.setResponse(quotation.get().getResponse());
			return quotationObject;
//			quotationDetails.add(quotationObject);
//		 if(data.getId() == id) {
//				System.out.print(data+"eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
//				QuotationDTO quotation = new QuotationDTO(null, null, null, null, null, null, null, null, null);
//				quotation.setDescription(data.getDescription());
//				quotation.setId(data.getId());
//				if(data.getImage()!=null) {
//				    String base64Image = Base64.getEncoder().encodeToString(data.getImage());
//			
//				    quotation.setImage(base64Image);
//			    }
//				quotation.setResponse(data.getResponse());
//				quotation.setStatus(data.getStatus());
//				if(data.getUser().getId() != null) {
//					User user = userRepository
//		                .findById(data.getUser().getId())
//		                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
//					quotation.setUser_id(user.getId());
//					System.out.print("ssssssssssssssssssssssssssssss"+user);
//					quotation.setUsername(user.getFirstname() + " " + user.getLastname());
//					quotation.setEmail(user.getEmail());
//					quotation.setMobile(user.getPhone());
//				}
//			return quotation;
//		 }
//		}
//	return null;

	}



	@Override
	public void updateStatus(Integer id, QuotationDTO quotation) {
		Quotation quotationData =quotationRepository
		        .findById(id)
		        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
		quotationData.setResponse(quotation.getResponse());
		quotationData.setStatus(quotation.getStatus());
		quotationRepository.save(quotationData);
	}


}
