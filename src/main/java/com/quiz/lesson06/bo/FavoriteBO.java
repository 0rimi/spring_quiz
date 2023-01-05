package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.dao.FavoriteDAO;
import com.quiz.lesson06.model.Favorite;

@Service
public class FavoriteBO {
	
	@Autowired
	private FavoriteDAO favoriteDAO;
	
	
	//insert
	public void addFavorite(Favorite favorite) {
		favoriteDAO.insertFavorite(favorite);
	}
	
	// selectAll
	public List<Favorite> getFavoriteList(){
		return favoriteDAO.selectFavoriteList();
	}
	
	// duplication
	public boolean existFavoriteByUrl(String url) {
		return favoriteDAO.existFavoriteByUrl(url);
	}

}
