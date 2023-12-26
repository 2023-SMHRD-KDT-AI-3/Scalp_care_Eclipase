package com.Iplus.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Iplus.entity.tb_member;
import com.Iplus.repository.MemberRepository;

@RestController
@Controller
public class LoginController {
	
	@Autowired
	private MemberRepository repo;

	// 넘겨받은 값을 가져올 때 매개변수의 이름은 key와 동일하게 작성해야 한다.
		@RequestMapping("/join")
		public String login(String id, String name, String m_class, String email, HttpSession session) {
			
			System.out.println("여기까진 온다!!" + id);
			tb_member member = new tb_member(id, name, m_class, email, null, null, null, null);
			repo.save(member);
			
			session.setAttribute("user", member);
			
			return "성공!";	
		}
}
