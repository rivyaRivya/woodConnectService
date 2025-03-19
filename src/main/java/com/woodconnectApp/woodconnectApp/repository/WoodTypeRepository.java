package com.woodconnectApp.woodconnectApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.woodconnectApp.woodconnectApp.dto.WoodTypeDTO;
import com.woodconnectApp.woodconnectApp.entity.WoodType;

public interface WoodTypeRepository extends JpaRepository<WoodType, Integer>{

	void save(WoodTypeDTO wood);


}
