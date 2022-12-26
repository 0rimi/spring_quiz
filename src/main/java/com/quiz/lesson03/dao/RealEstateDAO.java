package com.quiz.lesson03.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.model.RealEstate;

@Repository
public interface RealEstateDAO {
	
	public RealEstate selectRealEstate(int id);
	
	public List<RealEstate> selectRealEstateList(@Param("rentPrice") int rentPrice);
	
	public List<RealEstate> selectRealEstateList2(Map<String,Integer> condition);
	
	//public List<RealEstate> selectRealEstateList2(
	//		@Param("area") int area, @Param("price") int price;
	//		@Param 어노테이션에 의해서 하나의 맵이 된 것
	
	
	//Quiz02_1
	public int insertRealEstate(RealEstate realEstate);
	
	public int insertRealEstateField(
			@Param("realtorId") int realtorId,
			@Param("address") String address,
			@Param("area") int area,
			@Param("type") String type,
			@Param("price") int price,
			@Param("rentPrice") Integer rentPrice
			);
	
}
