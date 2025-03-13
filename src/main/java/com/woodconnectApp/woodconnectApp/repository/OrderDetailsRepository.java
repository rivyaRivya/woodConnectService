package com.woodconnectApp.woodconnectApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.woodconnectApp.woodconnectApp.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
	List<OrderDetails> findByorderTable_id(Integer id);

	List<OrderDetails> findByProductId(Integer id);
}
