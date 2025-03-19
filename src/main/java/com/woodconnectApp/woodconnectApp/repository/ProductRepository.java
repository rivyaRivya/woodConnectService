package com.woodconnectApp.woodconnectApp.repository;

import java.util.List;
import java.util.Optional;


import com.woodconnectApp.woodconnectApp.entity.Product;
import com.woodconnectApp.woodconnectApp.entity.User;


public interface ProductRepository extends JpaRepository<Product, Integer> {
	boolean existsByproductname(String productname);


	Object findById(Integer productId);
}
