package com.Iplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Iplus.entity.tb_admin_scalp_care;
import com.Iplus.entity.tb_member;
import com.Iplus.entity.tb_user_like;
import com.Iplus.repository.LikeRepository;

@Controller
public class LikeController {
	
	@Autowired
	private LikeRepository repo;

	
	// 좋아요 클릭
	// 넘겨받은 값을 가져올 때 매개변수의 이름은 key와 동일하게 작성해야 한다.
	@RequestMapping("/likeInsert")
	@ResponseBody
	public void like(String likeAcNum, String likeUid) {	

		boolean good;
		int likeCheck = repo.likeCheck(likeAcNum, likeUid);
		int hateCheck = repo.hateCheck(likeAcNum, likeUid);
		
	// 좋아요를 클릭했는데
		// 좋아요 O, 싫어요 X -> 좋아요 삭제
		if(likeCheck == 1 && hateCheck == 0) {
			repo.deletegood(likeAcNum, likeUid);
		}
		// 좋아요 X, 싫어요 O -> 싫어요 삭제 후 좋아요 넣기
		else if(likeCheck == 0 && hateCheck == 1) {
	        repo.deletehate(likeAcNum,likeUid);
	        good = true;
			repo.insert(good,likeAcNum,likeUid);				
		}
		// 좋아요 X, 싫어요 X -> 좋아요 넣기
		else if(likeCheck == 0 && hateCheck == 0){
			good = true;
			repo.insert(good,likeAcNum,likeUid);
		}
		// 좋아요 O, 싫어요 O
		else if(likeCheck == 1 && hateCheck == 1){
			System.out.println("안녕?");
		}	
        System.out.println("좋아요 DB 저장 완료!");
    }
		
	// 싫어요 클릭
	// 넘겨받은 값을 가져올 때 매개변수의 이름은 key와 동일하게 작성해야 한다.
	@RequestMapping("/hateInsert")
	@ResponseBody
	public void hate(String likeAcNum, String likeUid) {
		
		boolean good;
		int likeCheck = repo.likeCheck(likeAcNum, likeUid);
		int hateCheck = repo.hateCheck(likeAcNum, likeUid);
		
	// 싫어요를 클릭했는데
		// 좋아요 X, 싫어요 O -> 싫어요 삭제
		if(likeCheck == 0 && hateCheck == 1) {
			repo.deletehate(likeAcNum, likeUid);
		}
		// 좋아요 O, 싫어요 X -> 좋아요 삭제 후 싫어요 넣기
		else if(likeCheck == 1 && hateCheck == 0) {
	        repo.deletegood(likeAcNum,likeUid);
	        good = false;
			repo.insert(good,likeAcNum,likeUid);				
		}
		// 좋아요 X, 싫어요 X -> 싫어요 넣기
		else if(likeCheck == 0 && hateCheck == 0){
			good = false;
			repo.insert(good,likeAcNum,likeUid);
		}
		// 좋아요 O, 싫어요 O
		else if(likeCheck == 1 && hateCheck == 1){
			System.out.println("안녕???????");
		}		
        System.out.println("싫어요 DB 저장 완료!");
    }
		
	// 좋아요 수 출력
	@RequestMapping("/likeView")
	@ResponseBody
	public int likeView( String likeAcNum) {
		
	    int likeCount = repo.likeView(likeAcNum);
	    
//        System.out.println("게시글 출력"+likeAcNum);        
//	    System.out.println("좋아요 수 출력: " + likeCount);
	    
	    return likeCount;
	}
	
	// 싫어요 수 출력
	@RequestMapping("/hateView")
	@ResponseBody
	public int hateView( String likeAcNum) {
		
	    int hateCount = repo.hateView(likeAcNum);
	    
//        System.out.println("게시글"+likeAcNum);        
//	    System.out.println("싫어요 수: " + hateCount);
	    
	    return hateCount;
	}
	
	// 좋아요 사진 체크
	@RequestMapping("/likeCheckIcon")
	@ResponseBody
	public int likeCheckIcon( String likeAcNum, String likeUid) {
		int likeCheckIcon = repo.likeCheck(likeAcNum, likeUid);
	    
	    return likeCheckIcon;
	}
	
	// 싫어요 사진 체크
	@RequestMapping("/hateCheckIcon")
	@ResponseBody
	public int hateCheckIcon( String likeAcNum, String likeUid) {
		int hateCheckIcon = repo.hateCheck(likeAcNum, likeUid);
	    
	    return hateCheckIcon;
	}
}
