package com.woodconnectApp.woodconnectApp.service.impl;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.woodconnectApp.woodconnectApp.dto.WoodTypeDTO;
import com.woodconnectApp.woodconnectApp.entity.User;
import com.woodconnectApp.woodconnectApp.entity.WoodType;
import com.woodconnectApp.woodconnectApp.repository.WoodTypeRepository;
import com.woodconnectApp.woodconnectApp.services.WoodTypeServices;
@Service
public class WoodTypeServiceImpl implements WoodTypeServices{
	
	@Autowired
	private WoodTypeRepository woodtypeRepository;
	
	@Override
	public Integer createWoodType(WoodTypeDTO woodtypeData) {
		WoodType woodtypeinfo = new WoodType();
		woodtypeinfo.setWoodname(woodtypeData.getWoodname());
		woodtypeinfo.setPrice(woodtypeData.getPrice());
		woodtypeRepository.save(woodtypeinfo);
		return null;
	}



	public List<WoodTypeDTO> getWoods() {
		// TODO Auto-generated method stub
		return woodtypeRepository.findAll().stream()
		        .map(driver -> new WoodTypeDTO(driver.getId(), driver.getWoodname(), driver.getPrice()))
		        .collect(Collectors.toList());
	}
	@Override
	public void deleteWoodType(Integer id) {
		WoodType woodType = woodtypeRepository
                .findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));

		woodtypeRepository.delete(woodType);
	}
	@Override
	public void updateWoodType(Integer id, WoodTypeDTO wood) {
		WoodType woodData =woodtypeRepository
        .findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
		woodData.setPrice(wood.getPrice());
		woodtypeRepository.save(woodData);
	}
	@Override
	public WoodType getWoodDetail(Integer id) {
		WoodType woodType = woodtypeRepository
	                .findById(id)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
	        return woodType;
	}



	

}
