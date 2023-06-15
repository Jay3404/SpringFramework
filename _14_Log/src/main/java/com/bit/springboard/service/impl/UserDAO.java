package com.bit.springboard.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.bit.springboard.common.JDBCUtil;
import com.bit.springboard.dto.UserDTO;

@Repository("userDAO")
public class UserDAO {
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String JOIN_USER = "INSERT INTO T_USER(USER_ID, USER_PW, USER_NAME) VALUES (?, ?, ?)";
	
	private final String GET_USER = "SELECT ID, USER_ID, USER_NAME FROM T_USER WHERE ID = ?";
	
	//insert into T_USER
	public void join(UserDTO userDTO) {
		// TODO Auto-generated method stub
		System.out.println("joinUser 실행");

		try {
			conn = JDBCUtil.getConnection();
			
			stmt = conn.prepareStatement(JOIN_USER);
			
			stmt.setString(1, userDTO.getUserId());
			stmt.setString(2, userDTO.getUserPw());
			stmt.setString(3, userDTO.getUserName());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		
		
	}

	//select from T_USER WHERE ID = ?
	public UserDTO getUser(int id) {
		// TODO Auto-generated method stub
		System.out.println("getUser 실행");
		
		UserDTO userDTO = new UserDTO();
		
		try {
			
			conn = JDBCUtil.getConnection();
			
			stmt = conn.prepareStatement(GET_USER);
		
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				userDTO.setId(rs.getInt("ID"));
				userDTO.setUserId(rs.getString("USER_ID"));
				userDTO.setUserName(rs.getString("USER_NAME"));
			}
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return userDTO;
	}
	
}
