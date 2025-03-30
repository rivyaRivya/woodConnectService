package com.woodconnectApp.woodconnectApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.woodconnectApp.woodconnectApp.dto.ProductDTO;
import com.woodconnectApp.woodconnectApp.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
	List<Review> findByProductId(Integer id);
}
