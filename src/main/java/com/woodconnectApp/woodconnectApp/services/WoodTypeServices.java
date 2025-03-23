package com.woodconnectApp.woodconnectApp.services;


import com.woodconnectApp.woodconnectApp.dto.WoodTypeDTO;
import com.woodconnectApp.woodconnectApp.entity.WoodType;



public interface WoodTypeServices {
	void deleteWoodType(Integer id);


	WoodType getWoodDetail(Integer id);
	

}
