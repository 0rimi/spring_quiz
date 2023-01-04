package com.quiz.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.FavoriteBO;
import com.quiz.lesson06.model.Favorite;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	
	@Autowired
	private FavoriteBO favoriteBO;
	
	// http://localhost/lesson06/quiz01/view
	@GetMapping("/quiz01/view")
	public String quiz01_view() {
		return "lesson06/quiz01/view";
	}
	
	@ResponseBody
	@PostMapping("/quiz01/favorite")
	public Favorite quiz01_fav(@ModelAttribute Favorite favorite){
		
		System.out.println("controller : "+favorite);
		//db insert
		favoriteBO.addFavorite(favorite);
		
		return favorite;
	}
	
	@GetMapping("/quiz01/list")
	public String quiz01_list(Model model) {
		
		// db select
		List<Favorite> favoriteList = favoriteBO.getFavoriteList();
		
		// model > view
		model.addAttribute("favoriteList", favoriteList);
		
		return "lesson06/quiz01/favorite_list";
	}

}
