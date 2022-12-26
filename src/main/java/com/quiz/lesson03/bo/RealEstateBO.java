package com.quiz.lesson03.bo;

import java.util.HashMap;
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
	
	public List<RealEstate> getRealEstateList2(int area, int price) {
		Map<String,Integer> condition = new HashMap<>();
		condition.put("area", area);
		condition.put("price", price);
		
		return realEstateDAO.selectRealEstateList2(condition);
	}
	
	// Quiz02_1
	public int addRealEstate(RealEstate realEstate) {
		return realEstateDAO.insertRealEstate(realEstate);
	}
	
	public int addRealEstateField(
			int realtorId, String address, int area,
			String type, int price, Integer rentPrice
			) {
		return realEstateDAO.insertRealEstateField(realtorId, address, area, type, price, rentPrice);
	}
	
}
