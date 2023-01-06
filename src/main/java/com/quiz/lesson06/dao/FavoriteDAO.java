package com.quiz.lesson06.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson06.model.Favorite;

@Repository
public interface FavoriteDAO {

	//insert
	public void insertFavorite(Favorite favorite);
	
	// selectAll
	public List<Favorite> selectFavoriteList();
	
	// duplication
	public boolean existFavoriteByUrl(String url);
	
	// delete
	public int deleteFavoriteById(int id);
}
