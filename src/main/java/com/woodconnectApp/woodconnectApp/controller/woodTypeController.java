package com.woodconnectApp.woodconnectApp.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.woodconnectApp.woodconnectApp.dto.WoodTypeDTO;
import com.woodconnectApp.woodconnectApp.entity.WoodType;
import com.woodconnectApp.woodconnectApp.service.impl.WoodTypeServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class woodTypeController {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	@Autowired
    private WoodTypeServiceImpl woodtypeServices;

	
	@PostMapping("/wood-type")
    public String createWoodType(@RequestBody WoodTypeDTO  woodtypeinfo) {
       System.out.print(woodtypeinfo);
        
         woodtypeServices.createWoodType(woodtypeinfo);
        return "WoodType added successfully";
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
	    public ResponseEntity<Void> updateWoodType(@PathVariable Integer id, @RequestBody WoodTypeDTO wood) {
		  System.out.print(wood+"kkkkkkkkkkkkkkkkkk");
		  woodtypeServices.updateWoodType(id, wood);

	        return ResponseEntity.noContent().build();
	    }


}
