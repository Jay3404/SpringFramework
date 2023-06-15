package com.bit.springboard.service.user;

import com.bit.springboard.dto.UserDTO;

public interface UserService {
//	//insert into T_USER
//	void join(UserDTO userDTO);
//	
//	//select from T_USER where id = ?
//	
	
	void join(UserDTO userDTO);
	
	UserDTO getUser(int id);
	
	int idCheck(String userId);
	
	UserDTO login(UserDTO userDTO);
	
}
