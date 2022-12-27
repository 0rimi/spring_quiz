package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
	
	// field
	@Autowired
	private SellerBO sellerBO;
	
	
	// http://localhost/lesson04/quiz01/1
	@RequestMapping("/1")
	public String quiz01_1() {
		//add_seller.jsp
		return "/lesson04/add_seller";
	}
	
	// http://localhost/lesson04/quiz01/add_seller
	@PostMapping("/add_seller")
	public String quiz01_2(
			@RequestParam("nickname") String nickname,
			@RequestParam("profileImageUrl") String profileImageUrl,
			@RequestParam("temperature") double temperature
			){
		//insert
		sellerBO.addSeller(nickname,profileImageUrl,temperature);
		
		//after_add_seller.jsp
		return "/lesson04/after_add_seller";
	}
}
