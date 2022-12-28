package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.model.Seller;

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
			@RequestParam(value="temperature", required=false) Double temperature
			){
		//insert
		sellerBO.addSeller(nickname,profileImageUrl,temperature);
		
		//after_add_seller.jsp
		return "/lesson04/after_add_seller";
	}
	
//	// http://localhost/lesson04/quiz01/seller_info
//	@GetMapping("/seller_info")
//	public String quiz01_3(Model model) {
//		
//		// db 에서 셀러 가져오기
//		Seller seller = sellerBO.getSeller();
//		
//		// model
//		model.addAttribute("seller", seller);
//		
//		return "lesson04/sellerInfo";
//	}
	
	// http://localhost/lesson04/quiz01/seller_info?id=1
	@GetMapping("/seller_info")
	public String quiz01_4(
			@RequestParam(value="id",required = false) Integer id,Model model) {
		
		Seller seller = new Seller();
		
		// db 에서 셀러 가져오기
		if(id != null) {
			seller = sellerBO.getSellerById(id);
		}else {
			seller = sellerBO.getSeller();
		}
		
		
		// model
		model.addAttribute("seller", seller);
		
		return "lesson04/sellerInfo";
	}
}
