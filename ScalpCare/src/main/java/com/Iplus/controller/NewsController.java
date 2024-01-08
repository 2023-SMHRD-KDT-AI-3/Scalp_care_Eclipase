package com.Iplus.controller;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Iplus.entity.tb_admin_scalp_care;
import com.Iplus.entity.tb_member;
import com.Iplus.entity.tb_user_scalp_care;
import com.Iplus.repository.AdminScalpCareRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class NewsController {
	
	@Autowired
	private AdminScalpCareRepository repo;
	
	@RequestMapping("/Newsview")
	public List<String> Newsview() {
		
		List<tb_admin_scalp_care> ac_board = repo.findAll();	
		System.out.println("여기는?" + ac_board);		
		
		// 객체 → Json(String)
		ObjectMapper objectMapper = new ObjectMapper();
		
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
	
	@RequestMapping("/getImage2")
	public String getImage(String acNum) {
	
		System.out.println("이 함수 실행 안함?2");
		tb_admin_scalp_care ac_board = repo.findByAcNum(Long.valueOf(acNum));
		String base64_img = null;
		
	
		// 객체 → Json(String)
		ObjectMapper objectMapper = new ObjectMapper();
				
		
			try {
				// Base64로 인코딩
				byte[] imageBytes = Files.readAllBytes(Paths.get(ac_board.getImg()));
				
				base64_img = Base64.getEncoder().encodeToString(imageBytes);	
				System.out.println(base64_img.length());
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		return base64_img;	
	}	
	
	// 댓글 수 증가 후 출력
		@RequestMapping("/ViewPlus")
		@ResponseBody
		public int ViewPlus( String acNum) {
			// 업데이트
		    repo.ViewPlus(acNum);
		    
		    // 카운트
		    int ViewPlusCount = repo.ViewPlusCount(acNum);
		    
		    System.out.println("조회 수 출력: " + ViewPlusCount);
		    
		    return ViewPlusCount ;
		}
	
		
	// 인기 게시글 가져오기
	@RequestMapping("/NewsviewBest")
		public List<String> NewsviewBest() {
			
			List<tb_admin_scalp_care> ac_board = repo.NewsviewBest();	
			System.out.println("여기에 인기글 가져오고 싶당?" + ac_board);		
			
			// 객체 → Json(String)
			ObjectMapper objectMapper = new ObjectMapper();
			
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
