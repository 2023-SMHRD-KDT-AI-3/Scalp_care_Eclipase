package com.Iplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Iplus.entity.tb_member;
import com.Iplus.repository.MemberRepository;

@RestController
public class LoginController {
	
	@Autowired
	private MemberRepository repo;

	// 넘겨받은 값을 가져올 때 매개변수의 이름은 key와 동일하게 작성해야 한다.
		@RequestMapping("/join")
		public void login(String m_uid, String m_name, String m_class, String m_email) {
			System.out.println("저장하러 옴");
			tb_member member = new tb_member(m_uid, m_name, m_class, m_email);
			repo.save(member);
			System.out.println("DB저장 완료!");
				
		}
}
