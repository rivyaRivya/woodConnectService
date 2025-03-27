package com.woodconnectApp.woodconnectApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.woodconnectApp.woodconnectApp.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
	List<OrderDetails> findByorderTable_id(Integer id);

	List<OrderDetails> findByProductId(Integer id);
	
	@Query("SELECT COALESCE(SUM(od.quantity), 0) FROM OrderDetails od " +
	           "JOIN od.orderTable ot WHERE ot.user.id = :userId AND ot.status = 'pending'")
	    Integer getTotalCartCountByUserId(@Param("userId") Integer userId);
}
