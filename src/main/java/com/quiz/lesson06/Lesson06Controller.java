package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
		
		return favorite;	//Jackson > json string으로 보냄
	}
	
	// http://localhost/lesson06/quiz01/list
	@GetMapping("/quiz01/list")
	public String quiz01_list(Model model) {
		
		// db select
		List<Favorite> favoriteList = favoriteBO.getFavoriteList();
		
		// model > view
		model.addAttribute("favoriteList", favoriteList);
		
		return "lesson06/quiz01/favorite_list";
	}
	
	@ResponseBody
	@GetMapping("/quiz02/is_duplication")
	public Map<String,Boolean> is_duplication(
			@RequestParam("url") String url){
		
		Map<String,Boolean> result = new HashMap<>();
		result.put("isDuplication", favoriteBO.existFavoriteByUrl(url));	//true면 중복
		
		return result;
	}
	
	// http://localhost/lesson06/quiz02/delete_favorite?id=13 (test)
	//삭제요청 (ajax)
	@ResponseBody
	@DeleteMapping("/quiz02/delete_favorite")
	public Map<String, Object> delete_favorite(
			@RequestParam("id") int id){
		
		Map<String, Object> result = new HashMap<>();
		
		//db delete
		int row = favoriteBO.deleteFavoriteById(id);
		if (row>0) {
			result.put("code", 1);	//성공시 code번호(미리 지정해둔)
			result.put("result", "성공");
		}else {
			result.put("code", 500);
			result.put("result", "실패");
		}
		
		return result;
	}
}
