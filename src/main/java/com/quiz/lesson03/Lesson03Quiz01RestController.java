package com.quiz.lesson03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.model.Store;
import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.model.RealEstate;

@RequestMapping("/lesson03/quiz01")
@RestController
public class Lesson03Quiz01RestController {
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	//http://localhost/lesson03/quiz01/1?id=20
	@RequestMapping("/1")
	public RealEstate quiz01_1(@RequestParam("id") int id) {
		return realEstateBO.getRealEstate(id);
	}
	
	// http://localhost/lesson03/quiz01/2?rent_price=90
	@RequestMapping("/2")
	public List<RealEstate> quiz01_2(@RequestParam(value="rent_price", required = false) Integer rentPrice) {
		return realEstateBO.getRealEstateList(rentPrice);
	}
	
	// http://localhost/lesson03/quiz01/3?area=90&price=130000
	@RequestMapping("/3")
	public List<RealEstate> quiz01_3(
			@RequestParam("area") int area,
			@RequestParam("price") int price
			) {
		
		Map<String,Integer> condition = new HashMap<>();
		condition.put("area", area);
		condition.put("price", price);
		
		return realEstateBO.getRealEstateList2(condition);
	}
}
