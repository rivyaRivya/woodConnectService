package com.woodconnectApp.woodconnectApp.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.woodconnectApp.woodconnectApp.entity.OrderTable;
import com.woodconnectApp.woodconnectApp.entity.User;

public interface OrderTableRepository extends JpaRepository<OrderTable, Integer> {

	@Query("SELECT COUNT(o) FROM OrderTable o WHERE o.status = 'Delivered'")
	long countOrdersWithDeliveredStatus();
	
	@Query("SELECT d FROM User d WHERE d.id NOT IN (SELECT b.driver.id FROM OrderTable b WHERE b.status = 'Delivered')")
	List<User> findDriversNotInDeliveredBookings();
}
