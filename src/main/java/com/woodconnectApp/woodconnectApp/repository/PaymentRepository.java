package com.woodconnectApp.woodconnectApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.woodconnectApp.woodconnectApp.entity.Payment;


public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
