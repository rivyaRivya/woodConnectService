package com.woodconnectApp.woodconnectApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.woodconnectApp.woodconnectApp.dto.ReviewDTO;
import com.woodconnectApp.woodconnectApp.service.impl.ReviewServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000,http://localhost:8081", maxAge = 3600)
public class ReviewController {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	@Autowired
    private ReviewServiceImpl reviewServices;
	
	@PostMapping("/review")
    public String createReview(@RequestBody ReviewDTO  reviewinfo) {
       System.out.print(reviewinfo);
        
         reviewServices.createReview(reviewinfo);
        return "Review added successfully";
    }
	
	@GetMapping("/get-review")
	public ResponseEntity<List<ReviewDTO>> getReview(){
		return ResponseEntity.ok(reviewServices.getReview());
	} 
	
	
}
