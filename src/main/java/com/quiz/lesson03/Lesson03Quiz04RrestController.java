package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;

@RestController
@RequestMapping("/lesson03/quiz04")
public class Lesson03Quiz04RrestController {
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	// http://localhost/lesson03/quiz04/1?id=21
	@RequestMapping("/1")
	public String quiz04_1(@RequestParam("id") int id) {
		realEstateBO.deleteRealEstateById(id);
		return "삭제되었습니다.";
	}
}
