package com.quiz.lesson03.bo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.dao.RealEstateDAO;
import com.quiz.lesson03.model.RealEstate;

@Service
public class RealEstateBO {
	
	@Autowired
	private RealEstateDAO realEstateDAO;
	
	public RealEstate getRealEstate(int id) {
		return realEstateDAO.selectRealEstate(id);
	}
	
	public List<RealEstate> getRealEstateList(int rentPrice) {
		return realEstateDAO.selectRealEstateList(rentPrice);
	}
	
	public List<RealEstate> getRealEstateList2(Map<String,Integer> condition) {
		return realEstateDAO.selectRealEstateList2(condition);
	}
	
}
