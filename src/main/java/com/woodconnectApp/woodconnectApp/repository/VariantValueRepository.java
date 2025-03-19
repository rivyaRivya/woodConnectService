package com.woodconnectApp.woodconnectApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.woodconnectApp.woodconnectApp.entity.VariantValue;

public interface VariantValueRepository extends JpaRepository<VariantValue, Integer>{

	List<VariantValue> findByVariantId(Integer id);
}
