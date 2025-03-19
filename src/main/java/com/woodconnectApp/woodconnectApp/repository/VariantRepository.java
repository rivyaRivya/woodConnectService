package com.woodconnectApp.woodconnectApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.woodconnectApp.woodconnectApp.entity.Variant;

public interface VariantRepository  extends JpaRepository<Variant, Integer>{

}
