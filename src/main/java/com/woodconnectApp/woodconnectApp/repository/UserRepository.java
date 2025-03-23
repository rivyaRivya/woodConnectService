package com.woodconnectApp.woodconnectApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.woodconnectApp.woodconnectApp.entity.User;

public interface UserRepository  extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String string);
	 // Method to count orders with status 'Delivered'
    @Query("SELECT COUNT(o) FROM User o WHERE o.type = 'user'")
    long countOrdersWithCustomer();
    
    User findByEmailAndPassword(String email, String password);
    
    
}
