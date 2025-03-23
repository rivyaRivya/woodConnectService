package com.woodconnectApp.woodconnectApp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.woodconnectApp.woodconnectApp.dto.ProductDTO;
import com.woodconnectApp.woodconnectApp.dto.QuotationDTO;
import com.woodconnectApp.woodconnectApp.service.impl.QuotationServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000,http://localhost:8081", maxAge = 3600)
public class QuotationController {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	@Autowired
    private QuotationServiceImpl quotationServices;
	
	@PostMapping("/quotation")
    public ResponseEntity<String> createQuotation(
            @RequestParam("user_id") Integer user_id,
            @RequestParam(value = "image",required = false) MultipartFile image,

            @RequestParam("description") String description) {
		try {
	    	   
			byte[] imageBytes;
			if(image != null) {
				imageBytes = image.getBytes();
				}else {imageBytes = null;}
           quotationServices.createQuotation(description,user_id,imageBytes);
           return new ResponseEntity<String>("Quotation send.", HttpStatus.ACCEPTED);
        
 	   } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
        return null;
    }
	}
	@GetMapping("/list-quotation")
	public ResponseEntity<List<ProductDTO>> getProduct(){
		return ResponseEntity.ok(quotationServices.getQuotation());
	} 
	@GetMapping("/quotation-details")
    public QuotationDTO getproductdetails(@RequestParam Integer id) {
        return quotationServices.getQuotationDetailsf(id);
    }
	
	 @PutMapping("/update-quotation/{id}")
	    public ResponseEntity<Void> updatePaymentStatus(@PathVariable Integer id,@RequestBody QuotationDTO quotation) {
		 quotationServices.updateStatus(id,quotation);
	        return ResponseEntity.noContent().build();
	    }

}
