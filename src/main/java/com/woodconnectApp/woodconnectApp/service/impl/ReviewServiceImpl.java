package com.woodconnectApp.woodconnectApp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.woodconnectApp.woodconnectApp.dto.ReviewDTO;
import com.woodconnectApp.woodconnectApp.entity.Product;
import com.woodconnectApp.woodconnectApp.entity.Review;
import com.woodconnectApp.woodconnectApp.entity.User;
import com.woodconnectApp.woodconnectApp.repository.ProductRepository;
import com.woodconnectApp.woodconnectApp.repository.ReviewRepository;
import com.woodconnectApp.woodconnectApp.repository.UserRepository;
import com.woodconnectApp.woodconnectApp.services.ReviewServices;
@Service
public class ReviewServiceImpl implements ReviewServices {
	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;
	@Override
	public Integer createReview(ReviewDTO reviewData) {
		User user = userRepository.findById(reviewData.getUser_id())
				.orElseThrow(() -> new RuntimeException("UserId not found"));
		Product product = productRepository.findById(reviewData.getProduct_id())
				.orElseThrow(() -> new RuntimeException("product not found"));
		Review reviewinfo = new Review();
		reviewinfo.setUser(user);
		reviewinfo.setRating(reviewData.getRating());
		reviewinfo.setReview(reviewData.getReview());
		reviewinfo.setProduct(product);
		reviewRepository.save(reviewinfo);
		return null;
		}
	
	@Override
	public List getReview() {
		List<Review> reviews = reviewRepository.findAll();
		List<ReviewDTO> reviewDetails = new ArrayList<>();
		for (Review review : reviews) //to get multiple items
			{
			Optional<User> user = userRepository.findById(review.getUser().getId());
			ReviewDTO reviewObject = new ReviewDTO(null, null, null, null,null, null, null);
		    reviewObject.setId(review.getId());
		    reviewObject.setId(user.get().getId());
		    reviewObject.setReview(review.getReview());
		    reviewObject.setRating(review.getRating());
		    if(review.getProduct()!=null) {
		    	Optional<Product> product = productRepository.findById(review.getProduct().getId());
			     reviewObject.setProduct_id(product.get().getId());
		    	reviewObject.setProductname(product.get().getProductname());
		    }
		    reviewObject.setUsername(user.get().getFirstname()+" "+user.get().getLastname());
		   reviewDetails.add(reviewObject);
		}
		return reviewDetails;
		}
	}
	
	
	
