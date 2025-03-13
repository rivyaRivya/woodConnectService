package com.woodconnectApp.woodconnectApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.woodconnectApp.woodconnectApp.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {
	boolean existsByproductname(String productname);
}
