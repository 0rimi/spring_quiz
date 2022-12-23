package com.quiz.lesson03.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.model.RealEstate;

@Repository
public interface RealEstateDAO {
	
	public RealEstate selectRealEstate(@Param("id") int id);
	
	public List<RealEstate> selectRealEstateList(@Param("rentPrice") int rentPrice);
	
	public List<RealEstate> selectRealEstateList2(Map<String,Integer> condition);
	
}
