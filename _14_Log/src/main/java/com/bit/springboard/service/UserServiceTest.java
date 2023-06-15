package com.bit.springboard.service;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.bit.springboard.dto.UserDTO;

public class UserServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1. 스프링 컨테이너 구동
				AbstractApplicationContext factory = 
						new GenericXmlApplicationContext("root-context.xml");
				
				//2. BoardService 변수의 의존성 검색과 의존성 주입
				UserService userService = (UserService)factory.getBean("userService");

//				UserDTO userDTO = new UserDTO();
//				userDTO.setUserId("ssssss");
//				userDTO.setUserPw("sdgrwge");
//				userDTO.setUserName("양재민2");
//				
//				userService.join(userDTO);
				
				//3. user조회
				
				UserDTO returnUser = userService.getUser(1);
				System.out.println(returnUser);
		
		
	}

}
