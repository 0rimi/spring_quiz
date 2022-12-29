package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.model.Realtor;

@RequestMapping("/lesson04/quiz02")
@Controller
public class Lesson04Quiz02Controller {
	
	@Autowired
	private RealtorBO realtorBO;
	
	// http://localhost/lesson04/quiz02/add_realtor_view
	@GetMapping("/add_realtor_view")
	public String quiz02_1() {
		return "lesson04/addRealtorView";
	}
	
	// http://localhost/lesson04/quiz02/add_realtor
	@PostMapping("/add_realtor")
	public String quiz02_2(@ModelAttribute Realtor realtor,
				Model model) {
		System.out.println(realtor);
		
		// db insert
		realtorBO.addRealtor(realtor);
		
		// db select
		int id = realtor.getId();
		// 방금 insert된 정보
		realtor = realtorBO.getRealtorById(id);
		System.out.println("추가된 공인중개사:"+realtor);
		
		// model
		model.addAttribute("realtor", realtor);
		
		return "lesson04/afterAddRealtor";
	}

}
