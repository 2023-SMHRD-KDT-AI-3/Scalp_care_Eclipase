package com.Iplus.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Iplus.entity.tb_user_scalp_care;
import com.Iplus.repository.MemberRepository;
import com.Iplus.repository.UserScalpCareRepository;

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
	public List<tb_user_scalp_care> Boardview(tb_user_scalp_care care) {
		
		List<tb_user_scalp_care> result = repo.findAll();
		
		System.out.println(result);
		return result;	
	}	
}
