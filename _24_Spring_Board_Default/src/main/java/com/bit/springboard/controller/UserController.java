package com.bit.springboard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.springboard.dto.UserDTO;
import com.bit.springboard.service.user.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
//클래스 자체를 RequestMapping으로 설정하면 폴더 구조로 요청을 지정할 수 있다.
//UserController의 요청을 호출할 때는 /User/login.do
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	//회원가입페이지로 이동
	@GetMapping("/join.do")
	public String joinView() {
		
		//WEB-INF/views/home.jsp => return "home";
		//WEB-INF/views/user/join.jsp
		return "user/join";
	}
	
	@PostMapping("/join.do")
	public String join(UserDTO userDTO) {
		userService.join(userDTO);
		
		return "user/login";
	}
	
	@GetMapping("/login.do")
	public String loginView() {
		
		return "user/login";
	}
	
	@PostMapping("/login.do")
	public String login(UserDTO userDTO, Model model, HttpSession session) {
		
		int idCheck = userService.idCheck(userDTO.getUserId());
		
		if(idCheck < 1) {
			model.addAttribute("message", "idNotExist");
			return "user/login";
		}else {
			UserDTO loginUser = userService.login(userDTO);
			
			if(loginUser == null) {
				model.addAttribute("message", "wrongPw");
				return "user/login";
			} 
			
			session.setAttribute("loginUser", loginUser);
			
		}
		
		return "redirect:/index.jsp";
	}
	
	@GetMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/index.jsp";
	}
	
	@PostMapping("/idCheck.do")
	@ResponseBody
	public String idCheck(UserDTO userDTO) throws JsonProcessingException {
		
		int idCheck = userService.idCheck(userDTO.getUserId());
		
//		if(idCheck > 0) {
//			return "duplicatedId";
//		}
//		
//		return "idOk";
		
		ObjectMapper mapper = new ObjectMapper();
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		if(idCheck > 0) {
			jsonMap.put("msg", "duplicatedId");
		} else {
			jsonMap.put("msg", "idOk");
		}
		
		
		String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonMap);
		
		
		return jsonStr;
	}
	
	
	
	
}
