package com.bit.springboard.service.user.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.springboard.dto.UserDTO;

@Repository("userDAO")
public class UserDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
		
	public void join(UserDTO userDTO) {
		// TODO Auto-generated method stub
		//여기서 userDTO에 담긴 내용을 insert
		System.out.println(userDTO);
		
		mybatis.insert("UserDAO.join", userDTO);
	}

	public UserDTO getUser(int id) {
		// TODO Auto-generated method stub
		
		UserDTO userDTO = mybatis.selectOne("UserDAO.getUser", id);
		
		return userDTO;
		
	}
	
	public int idCheck(String userId) {
		return mybatis.selectOne("UserDAO.idCheck", userId);
	}
	
	public UserDTO login(UserDTO userDTO) {
		return mybatis.selectOne("UserDAO.login", userDTO);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
