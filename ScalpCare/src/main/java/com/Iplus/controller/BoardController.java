package com.Iplus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Iplus.entity.tb_user_scalp_care;
import com.Iplus.repository.MemberRepository;
import com.Iplus.repository.UserScalpCareRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@RestController
public class BoardController {
	
	@Autowired
	private UserScalpCareRepository repo;

	// 넘겨받은 값을 가져올 때 매개변수의 이름은 key와 동일하게 작성해야 한다.
	@RequestMapping("/Boardsave")
	public String Boardsave(tb_user_scalp_care care) {
		
		repo.save(care);
		
		
		return "성공!";	
	}
		
	@RequestMapping("/Boardview")
	public List<String> Boardview(tb_user_scalp_care care) {
		
		List<tb_user_scalp_care> uc_board = repo.findAll();
		
		// 객체 → Json(String)
		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println(uc_board);
		
		// String List
		List<String> jsonList = new ArrayList<>();
		String jsonString ;
			try {
				for (tb_user_scalp_care obj : uc_board) {
					// 객체 → Json형태 String → StringList에 담음
					jsonString = objectMapper.writeValueAsString(obj);
					jsonList.add(jsonString);
				}
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		return jsonList;	
	}	
}
