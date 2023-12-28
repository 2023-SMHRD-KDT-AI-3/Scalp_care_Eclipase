package com.Iplus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Iplus.entity.tb_admin_scalp_care;
import com.Iplus.repository.AdminScalpCareRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class NewsController {
	
	@Autowired
	private AdminScalpCareRepository repo;
	
	@RequestMapping("/Newsview")
	public List<String> Newsview(tb_admin_scalp_care care) {
		System.out.println("여기까진 옴");
		List<tb_admin_scalp_care> ac_board = repo.findAll();
		
		// 객체 → Json(String)
		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println("여기는?" + ac_board);
		
		// String List
		List<String> jsonList = new ArrayList<>();
		String jsonString;
			try {
				for(tb_admin_scalp_care obj : ac_board) {
					System.out.println(obj);
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
