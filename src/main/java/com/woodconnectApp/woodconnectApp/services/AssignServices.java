package com.woodconnectApp.woodconnectApp.services;

import java.util.List;

import com.woodconnectApp.woodconnectApp.dto.AssignDTO;

public interface AssignServices {
	
	void createAssign(AssignDTO assignData);
	List<AssignDTO> getAssign();

}
