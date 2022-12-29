package com.quiz.lesson04.dao;

import org.springframework.stereotype.Repository;

import com.quiz.lesson04.model.Realtor;

@Repository
public interface RealtorDAO {
	
	//insert
	public void insertRealtor(Realtor realtor);
	
	//select
	public Realtor selectRealtorById(int id);

}
