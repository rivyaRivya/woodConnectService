package com.woodconnectApp.woodconnectApp.controller;

import java.io.IOException;
import java.util.List;

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

import com.woodconnectApp.woodconnectApp.dto.WoodTypeDTO;
import com.woodconnectApp.woodconnectApp.entity.WoodType;
import com.woodconnectApp.woodconnectApp.service.impl.WoodTypeServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000,http://localhost:8081", maxAge = 3600)
public class woodTypeController {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	@Autowired
    private WoodTypeServiceImpl woodtypeServices;

	
	@PostMapping("/wood-type")
    public String createWoodType(
            @RequestParam("woodName") String woodname,
            @RequestParam("price") String price,
            @RequestParam("image") MultipartFile image) {
		 try {
	    	   
      	   byte[] imageBytes = image.getBytes();
      	 woodtypeServices.createWoodType(woodname,price,imageBytes);
         return "WoodType added successfully";
  	   } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
         
    }
	
	
	@GetMapping("/wood-type")
	public ResponseEntity<List<WoodTypeDTO>> getProduct(){
		return ResponseEntity.ok(woodtypeServices.getWoods());
	} 
	   @GetMapping("/woodType-details")
	    public WoodType getwoodTypedetails(@RequestParam Integer id) {
	        return woodtypeServices.getWoodDetail(id);
	    }
	 @DeleteMapping("delete-wood-type/{id}")
	    public ResponseEntity<Void> deleteWoodType(@PathVariable Integer id){
	    	woodtypeServices.deleteWoodType(id);
	        return ResponseEntity.noContent().build();
	    }
	  @PutMapping("/wood-type/{id}")
	    public ResponseEntity<Void> updateWoodType(@PathVariable Integer id,
	            @RequestParam("woodName") String woodname,
	            @RequestParam("price") String price,
	            @RequestParam("image") MultipartFile image) {
		  try {byte[] imageBytes;
				if(image != null) {
				imageBytes = image.getBytes();
				}else {imageBytes = null;}

				  woodtypeServices.updateWoodType(id, woodname,price,imageBytes);
			    
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return ResponseEntity.noContent().build();
	    }


}
