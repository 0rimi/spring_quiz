package com.quiz.lesson05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {
	
	// http://localhost/lesson05/quiz01
	@GetMapping("/quiz01")
	public String quiz01() {
		return "lesson05/quiz01";
	}
	
	// http://localhost/lesson05/quiz02
	@GetMapping("/quiz02")
	public String quiz02(Model model) {
		
		List<String> musicRanking = new ArrayList<>();
		musicRanking.add("D.D.D");
		musicRanking.add("The Stealer");
		musicRanking.add("Thrillride");
		musicRanking.add("Maverick");
		musicRanking.add("Whisper");
		
		model.addAttribute("musics", musicRanking);
		
		/////////////////////////////////////
		
		List<Map<String, Object>> membership = new ArrayList<>();

		Map<String, Object> member = new HashMap<>();
		member.put("name", "김영훈");
		member.put("phoneNumber", "010-1234-5678");
		member.put("grade", "VIP");
		member.put("point", 12040);
		membership.add(member);

		member = new HashMap<>();
		member.put("name", "이재현");
		member.put("phoneNumber", "010-4321-1234");
		member.put("grade", "BASIC");
		member.put("point", 3420);
		membership.add(member);

		member = new HashMap<>();
		member.put("name", "이주연");
		member.put("phoneNumber", "010-8888-1111");
		member.put("grade", "GOLD");
		member.put("point", 1530);
		membership.add(member);

		member = new HashMap<>();
		member.put("name", "김선우");
		member.put("phoneNumber", "010-0000-1234");
		member.put("grade", "GOLD");
		member.put("point", 8450);
		membership.add(member);

		member = new HashMap<>();
		member.put("name", "이상연");
		member.put("phoneNumber", "010-1111-2222");
		member.put("grade", "BASIC");
		member.put("point", 420);
		membership.add(member);
		
		model.addAttribute("membership", membership);
		
		return "lesson05/quiz02";
	}

}
