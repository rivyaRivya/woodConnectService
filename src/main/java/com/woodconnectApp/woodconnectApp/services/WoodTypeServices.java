package com.woodconnectApp.woodconnectApp.services;


import com.woodconnectApp.woodconnectApp.dto.WoodTypeDTO;
import com.woodconnectApp.woodconnectApp.entity.WoodType;



public interface WoodTypeServices {
	Integer createWoodType(WoodTypeDTO woodtypeData);

	void deleteWoodType(Integer id);

	void updateWoodType(Integer id, WoodTypeDTO wood);

	WoodType getWoodDetail(Integer id);
	

}
