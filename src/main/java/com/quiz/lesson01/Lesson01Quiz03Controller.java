package com.quiz.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson01Quiz03Controller {
	
	//	http://localhost/lesson01/quiz03/1
	@RequestMapping("/lesson01/quiz03/1")
	public String ex02() {
		return "lesson01/quiz03";
	}
	
}
