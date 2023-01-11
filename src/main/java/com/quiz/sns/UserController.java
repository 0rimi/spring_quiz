package com.quiz.sns;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sns/user")
@Controller
public class UserController {
	
	// 회원가입 (http://localhost/sns/user/sign_up)
	@GetMapping("/sign_up")
	public String signUpView() {
		return "sns/user/sign_up";
	}

}
