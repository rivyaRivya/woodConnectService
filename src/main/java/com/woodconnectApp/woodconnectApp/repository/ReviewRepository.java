package com.woodconnectApp.woodconnectApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.woodconnectApp.woodconnectApp.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
