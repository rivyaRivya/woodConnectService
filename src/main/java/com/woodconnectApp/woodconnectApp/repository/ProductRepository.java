package com.woodconnectApp.woodconnectApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.woodconnectApp.woodconnectApp.entity.OrderDetails;
import com.woodconnectApp.woodconnectApp.entity.Product;
import com.woodconnectApp.woodconnectApp.entity.User;


public interface ProductRepository extends JpaRepository<Product, Integer> {
	boolean existsByproductname(String productname);
	List<Product> findByWoodTypeId(Integer id);
	
	 @Query("SELECT p FROM Product p WHERE LOWER(p.productname) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	    List<Product> searchProducts(@Param("keyword") String keyword);

}
