package com.Iplus.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Iplus.entity.tb_admin_scalp_care;
import com.Iplus.entity.tb_member;
import com.Iplus.entity.tb_review;
import com.Iplus.entity.tb_user_scalp_care;
import com.Iplus.repository.MemberRepository;
import com.Iplus.repository.ReviewRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ReviewController {
	
	@Autowired
	private ReviewRepository repo;
	
	@Autowired
	private MemberRepository m_repo;

	// 댓글 입력
	// 넘겨받은 값을 가져올 때 매개변수의 이름은 key와 동일하게 작성해야 한다.
		@RequestMapping("/reviewInsert")
		public void reviewInsert(String reAcNum, String reUid, String content) {
			System.out.println("댓글 저장하러 옴");
			
			repo.reviewInsert(reAcNum, reUid, content);
			
			System.out.println("댓글 DB저장 완료!");
				
		}
	
	// 댓글 출력
		@RequestMapping("/reviewView")
		public List<String> reviewView(Long reAcNum) { 
			System.out.println("여기까지 와라");
			
//			tb_admin_scalp_care admin = new tb_admin_scalp_care();
//			admin.setAcNum(reAcNum);
			
			tb_admin_scalp_care ac = new tb_admin_scalp_care();
			ac.setAcNum(reAcNum);

			// 내림차순으로 정렬
			List<tb_review> re_board = repo.findAllByReAcNum(ac);
			//List<tb_review> re_board = repo.findAllByUcUid(admin);
			
			System.out.println("확인" + re_board.size());
			String board_uid = re_board.get(0).getReUid().getUid();
						
			for(int i=0; i<re_board.size(); i++) {
				
				re_board.get(i).getReUid().setUid(m_repo.findByUid(board_uid).getName());
			}
			
			System.out.println("확인2 : " + re_board.get(0).getReUid().getName());
			
			// 객체 → Json(String)
			ObjectMapper objectMapper = new ObjectMapper();
			
			// String List
			List<String> jsonList = new ArrayList<>();
			String jsonString ;
			String json1;
				try {
					for (tb_review obj : re_board) {
					
						// 객체 → Json형태 String → StringList에 담음
						json1 = objectMapper.writeValueAsString(obj.getReUid());
						jsonList.add(json1);
						jsonString = objectMapper.writeValueAsString(obj);
						jsonList.add(jsonString);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			return jsonList;
		}
}
