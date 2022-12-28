package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.dao.SellerDAO;
import com.quiz.lesson04.model.Seller;

@Service
public class SellerBO {
	
	@Autowired
	private SellerDAO sellerDAO;
	
	public void addSeller(String nickname,String profileImageUrl,Double temperature){
		sellerDAO.insertSeller(nickname,profileImageUrl,temperature);
	};

	//select one : last seller
	public Seller getSeller() {
		return sellerDAO.selectSeller();
	}
	
	//select one : by id
	public Seller getSellerById(int id) {
		return sellerDAO.selectSellerById(id);
	}

}
