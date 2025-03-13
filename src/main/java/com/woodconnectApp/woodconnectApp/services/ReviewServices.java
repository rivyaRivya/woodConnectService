package com.woodconnectApp.woodconnectApp.services;

import java.util.List;

import com.woodconnectApp.woodconnectApp.dto.ReviewDTO;

public interface ReviewServices {
	Integer createReview(ReviewDTO reviewData);
	List<ReviewDTO> getReview();

}
