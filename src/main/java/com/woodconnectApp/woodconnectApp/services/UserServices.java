package com.woodconnectApp.woodconnectApp.services;

import com.woodconnectApp.woodconnectApp.dto.UserDTO;
import com.woodconnectApp.woodconnectApp.entity.User;

public interface UserServices {
	Integer createUser(UserDTO userData);
	Integer login(UserDTO userData);
	void deleteUser(Integer id);
	void updateUser(Integer id, UserDTO user);
	UserDTO getUserDetail(Integer id);
	

}
