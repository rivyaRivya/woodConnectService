package com.woodconnectApp.woodconnectApp.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.woodconnectApp.woodconnectApp.dto.ProductDTO;
import com.woodconnectApp.woodconnectApp.dto.WoodTypeDTO;
import com.woodconnectApp.woodconnectApp.entity.Product;
import com.woodconnectApp.woodconnectApp.entity.WoodType;
import com.woodconnectApp.woodconnectApp.service.impl.ProductServiceImpl;
import com.woodconnectApp.woodconnectApp.service.impl.WoodTypeServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class productController {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	@Autowired
    private ProductServiceImpl productServices;
	
	@PostMapping("/product")
    public ResponseEntity createProduct(@RequestParam("productname") String productname,
            @RequestParam("description") String description,
            @RequestParam("price") String price,
            @RequestParam("woodType_id") Integer woodType_id,
            @RequestParam("stock") String stock,
            @RequestParam("image") MultipartFile image,
            @RequestParam("manufacture") String manufacture,
            @RequestParam("length") String length,
            @RequestParam("width") String width, 
            @RequestParam("labourPrice") String labourPrice,
            @RequestParam("manufacturePrice") String manufacturePrice) {
    // Convert image to byte array
       try {
    	   
        	   byte[] imageBytes = image.getBytes();
        	   productServices.createProduct(productname,description,price,woodType_id,imageBytes,manufacture, stock,length,width,labourPrice,manufacturePrice);
        	   return new ResponseEntity("Product added.", HttpStatus.ACCEPTED);
           
    	   } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
        
    }
	
	@GetMapping("/get-product")
	public ResponseEntity<List<ProductDTO>> getProduct(){
		return ResponseEntity.ok(productServices.getProduct());
	} 
	@GetMapping("/product-details")
    public ProductDTO getproductdetails(@RequestParam Integer id) {
        return productServices.getProductDetail(id);
    }

	 @DeleteMapping("delete-product/{id}")
	    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id){
	    	productServices.deleteProduct(id);
	        return ResponseEntity.noContent().build();
	    }
	 @PutMapping("/update-product/{id}")
	    public ResponseEntity<Void> updateWoodType(@PathVariable Integer id, @RequestParam("productname") String productname,
	            @RequestParam("description") String description,
	            @RequestParam("price") String price,
	            @RequestParam("woodType_id") Integer woodType_id,
	            @RequestParam("stock") String stock,
	            @RequestParam(value = "image",required = false) MultipartFile image,
	            @RequestParam("manufacture") String manufacture,
	            @RequestParam("length") String length,
	            @RequestParam("width") String width,
	            @RequestParam("labourPrice") String labourPrice,
	            @RequestParam("manufacturePrice") String manufacturePrice) {
		 byte[] imageBytes;
		try {
			if(image != null) {
			imageBytes = image.getBytes();
			}else {imageBytes = null;}
			productServices.updateProduct(id, productname,description,price,woodType_id,imageBytes,manufacture, stock,length,width,labourPrice,manufacturePrice);

		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		     return ResponseEntity.noContent().build();
	    }
	    


}
