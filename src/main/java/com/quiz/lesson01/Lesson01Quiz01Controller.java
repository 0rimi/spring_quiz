package com.quiz.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lesson01/quiz01")
public class Lesson01Quiz01Controller {
	
	// http://localhost:9090/lesson01/quiz01/1
	@ResponseBody
	@RequestMapping("/1")
	public String printString() {
		String test = "<h1>테스트 프로젝트 완성</h2><br>"
				+ "<h3>해당 프로젝트를 통해서 문제 풀이를 진행합니다.</h3>";
		return test;
	}
	
	@ResponseBody
	@RequestMapping("/2")
	public Map<String,Integer> printMap() {
		Map<String,Integer> score = new HashMap<>();
		score.put("국어",80);
		score.put("수학",90);
		score.put("영어",85);
		
		return score;
	}

}
