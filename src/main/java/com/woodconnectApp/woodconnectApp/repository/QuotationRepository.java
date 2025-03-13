package com.woodconnectApp.woodconnectApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.woodconnectApp.woodconnectApp.entity.Quotation;

public interface QuotationRepository extends JpaRepository<Quotation, Integer> {
	List<Quotation> findByDescription(String Description);

}
