package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.dao.BookingDAO;
import com.quiz.lesson06.model.Booking;

@Service
public class BookingBO {
	
	@Autowired
	private BookingDAO bookingDAO;
	
	
	//select All : ListAll
	public List<Booking> getBookingList(){
		return bookingDAO.selectBookingList();
	}
	
	//deleteById
	public int deleteBookingById(int id) {
		return bookingDAO.deleteBookingById(id);
	}
	
	// insert
	public int addBooking(Booking booking) {
		return bookingDAO.insertBooking(booking);
	}
	
	// selectOne : name, phoneNumber 조회
	public Booking getBooking(String name, String phoneNumber) {
		return bookingDAO.selectBooking(name,phoneNumber);
	}

}
