package com.quiz.lesson05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson05.bo.WeatherBO;
import com.quiz.lesson05.model.Member;
import com.quiz.lesson05.model.Weather;

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

	// http://localhost/lesson05/quiz03
	@GetMapping("/quiz03")
	public String quiz03(Model model) {

		List<Integer> candidates = new ArrayList<>();
		candidates.add(263001);
		candidates.add(173942);
		candidates.add(563057);

		int totalCnt = 0;
		for (int i = 0; i < candidates.size(); i++) {
			totalCnt += candidates.get(i);
		}

		model.addAttribute("candidates", candidates);
		model.addAttribute("totalCnt", totalCnt);

		////////////////////////////////////////////

		List<Map<String, Object>> cardBills = new ArrayList<>();

		Map<String, Object> cardBill = new HashMap<>();
		cardBill.put("store", "GS48");
		cardBill.put("pay", 7800);
		cardBill.put("date", "2025-09-14");
		cardBill.put("installment", "일시불");
		cardBills.add(cardBill);

		cardBill = new HashMap<>();
		cardBill.put("store", "현태백화점");
		cardBill.put("pay", 2750000);
		cardBill.put("date", "2025-09-18");
		cardBill.put("installment", "3개월");
		cardBills.add(cardBill);

		cardBill = new HashMap<>();
		cardBill.put("store", "요촌치킨");
		cardBill.put("pay", 180000);
		cardBill.put("date", "2025-09-20");
		cardBill.put("installment", "일시불");
		cardBills.add(cardBill);

		model.addAttribute("cardBills", cardBills);

		return "lesson05/quiz03";
	}

	// http://localhost/lesson05/quiz04
	@GetMapping("/quiz04")
	public String quiz04(Model model) {

		List<Member> members = new ArrayList<>();

		Member member = new Member();
		member.setName("영훈");
		member.setPhoneNumber("010-1234-5678");
		member.setEmail("yh0808@gmail.com");
		member.setNationality("삼국시대 촉한");
		member.setIntroduce("저는 촉의 군주 영훈입니다. 삼국통일을 위해 열심히 일하겠습니다.");
		members.add(member);

		member = new Member();
		member.setName("재현");
		member.setPhoneNumber("02-111-3333");
		member.setNationality("삼국시대 촉한");
		member.setEmail("jh0913@gmail.com");
		member.setIntroduce("이재현임");
		members.add(member);

		member = new Member();
		member.setName("주연");
		member.setPhoneNumber("010-1234-5678");
		member.setEmail("jy0115@naver.com");
		member.setNationality("삼국시대 촉한");
		member.setIntroduce("주연이에요. 저는 재현형님 보다 나이는 많지만 일단 아우입니다.");
		members.add(member);

		member = new Member();
		member.setName("선우");
		member.setPhoneNumber("010-0987-4321");
		member.setNationality("삼국시대 위");
		member.setEmail("sw0412@gmail.com");
		member.setIntroduce("이름은 선우 성은 김이라 하오");
		members.add(member);

		member = new Member();
		member.setName("주유");
		member.setPhoneNumber("010-0000-1111");
		member.setNationality("삼국시대 오");
		member.setEmail("jooyou@kakao.com");
		member.setIntroduce("주유는 주유소에서 ㅋㅋ");
		members.add(member);

		member = new Member();
		member.setName("황충");
		member.setPhoneNumber("031-432-0000");
		member.setNationality("삼국시대 촉한");
		member.setEmail("yellowbug@naver.com");
		member.setIntroduce("내 수염 좀 멋있는 듯");
		members.add(member);

		model.addAttribute("members", members);

		return "lesson05/quiz04";
	}

}
