package com.bit.springboard.service;

import com.bit.springboard.dto.UserDTO;

public interface UserService {
	void join(UserDTO userDTO);
	
	UserDTO getUser(int id);
}
