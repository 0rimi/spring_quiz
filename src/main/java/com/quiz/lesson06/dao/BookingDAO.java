package com.quiz.lesson06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson06.model.Booking;

@Repository
public interface BookingDAO {

	public List<Booking> selectBookingList();
	
	public int deleteBookingById(int id);
	
	// insert
	public int insertBooking(Booking booking);
	
	//selectOne By name, phoneNumber
	public Booking selectBooking(
			@Param("name") String name,
			@Param("phoneNumber") String phoneNumber
			);
	
}
