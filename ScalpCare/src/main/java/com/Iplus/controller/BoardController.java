package com.Iplus.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Iplus.entity.tb_admin_scalp_care;
import com.Iplus.entity.tb_member;
import com.Iplus.entity.tb_user_scalp_care;
import com.Iplus.repository.UserScalpCareRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RestController
public class BoardController {
	
	@Autowired
	private UserScalpCareRepository repo;

	// 넘겨받은 값을 가져올 때 매개변수의 이름은 key와 동일하게 작성해야 한다.
	@RequestMapping("/Boardsave")
	public void Boardsave(String content, String img, String ucUid, String indate, String result) {

		System.out.println("오고있지?");
		System.out.println(ucUid);
		
		// 이미지 Base64에서 이름 설정하기
		String img_name = img.substring(0,20);
		
		// 이미지 경로 설정
		String savePath = "C:/Users/smhrd/Desktop/project/user_scalp_img/"+ ucUid + "-" + img_name +".png";
		
		
		// Base64 공백 제거
		img = img.replaceAll("\\s+", "");
		System.out.println(img.length());
		
		byte[] decodeBytes = Base64.getDecoder().decode(img.getBytes());
				
		// 이미지 저장
		try {
            ByteArrayInputStream bis = new ByteArrayInputStream(decodeBytes);
            BufferedImage image = ImageIO.read(bis);
            
            // 이미지를 파일로 저장 (예: PNG 형식)
            File outputFile = new File(savePath);
            ImageIO.write(image, "png", outputFile);
            
            System.out.println("Image saved successfully!");
        } catch (IOException e) {
            System.out.println("Error converting byte array to image: " + e.getMessage());
        }
		
		tb_user_scalp_care sc_care = new tb_user_scalp_care();
		
		tb_member member = new tb_member();
		member.setUid(ucUid);
        
		sc_care.setUcUid(member);
		sc_care.setImg(savePath);
		sc_care.setContent(content);
		sc_care.setResult(result);
		
		repo.save(sc_care);

	}
		
	@RequestMapping("/Boardview")
	public List<String> Boardview(String ucUid) {

		tb_member member = new tb_member();
		member.setUid(ucUid);

		// 게시글 불러오기
		List<tb_user_scalp_care> uc_board = repo.Boardview(member);
		
		// 객체 → Json(String)
		ObjectMapper objectMapper = new ObjectMapper();
		
		// String List
		List<String> jsonList = new ArrayList<>();
		String jsonString ;
			try {
				for (tb_user_scalp_care obj : uc_board) {
				
					// 객체 → Json형태 String → StringList에 담음
					jsonString = objectMapper.writeValueAsString(obj);
					jsonList.add(jsonString);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return jsonList;	
	}	
	
	@RequestMapping("/getImage")
	public String getImage(String ucNum) {		
		// DB에서 경로 받아옴
		System.out.println("여기 왔니?");

		tb_user_scalp_care uc_board = repo.findByUcNum(Long.valueOf(ucNum));
		String base64_img = null;
		
	
		// 객체 → Json(String)
		ObjectMapper objectMapper = new ObjectMapper();
				
		
			try {
				// 경로를 이용하여 이미지 가져오기
				byte[] imageBytes = Files.readAllBytes(Paths.get(uc_board.getImg()));
				
				// Base64로 인코딩
				base64_img = Base64.getEncoder().encodeToString(imageBytes);	
				System.out.println(base64_img.length());
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		return base64_img;	
	}	
	
	// 최근 게시글 가져오기
	@RequestMapping("/getBoardDataRecent")
		public List<String> getBoardDataRecent(String ucUid) {
			
			tb_member member = new tb_member();
			member.setUid(ucUid);
			
			List<tb_user_scalp_care> bc_board = repo.Boardview(member);	
			System.out.println("여기에 최근글 가져오고 싶당?" + bc_board);		
			
			// 객체 → Json(String)
			ObjectMapper objectMapper = new ObjectMapper();
			
			// String List
			List<String> jsonList = new ArrayList<>();
			String jsonString;
				try {
					for(tb_user_scalp_care obj : bc_board) {
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
