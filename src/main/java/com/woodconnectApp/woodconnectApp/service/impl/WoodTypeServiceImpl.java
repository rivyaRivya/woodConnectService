package com.woodconnectApp.woodconnectApp.service.impl;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
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


	public List<WoodTypeDTO> getWoods() {
		// TODO Auto-generated method stub
		return woodtypeRepository.findAll().stream()
		        .map(driver -> new WoodTypeDTO(driver.getId(), driver.getWoodname(), driver.getPrice(), driver.getImage()))
		        .collect(Collectors.toList());
	}
	@Override
	public void deleteWoodType(Integer id) {
		WoodType woodType = woodtypeRepository
                .findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));

		woodtypeRepository.delete(woodType);
	}
	
	@Override
	public WoodType getWoodDetail(Integer id) {
		WoodType woodType = woodtypeRepository
	                .findById(id)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
	        return woodType;
	}



	public void createWoodType(String woodname, String price, byte[] imageBytes) {
		// TODO Auto-generated method stub
		WoodType woodtypeinfo = new WoodType();
		woodtypeinfo.setWoodname(woodname);
		woodtypeinfo.setPrice(price);
		woodtypeinfo.setImage(imageBytes);
		woodtypeRepository.save(woodtypeinfo);
		return;
	}



	public void updateWoodType(Integer id, String woodname, String price, byte[] imageBytes) {
		// TODO Auto-generated method stub
		WoodType woodData =woodtypeRepository
		        .findById(id)
		        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
				woodData.setPrice(price);
				woodData.setImage(imageBytes);
				woodtypeRepository.save(woodData);
	}



	

}
