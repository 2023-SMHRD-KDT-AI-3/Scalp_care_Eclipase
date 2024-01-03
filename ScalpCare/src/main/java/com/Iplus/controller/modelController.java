package com.Iplus.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Iplus.entity.imgClassifier;

import antlr.collections.List;

@RestController
public class modelController {
	
	imgClassifier model = new imgClassifier();
	
	@PostMapping("/classify")
    public void classify(String img) {
		
		model.predict(null);

        
    }

}
