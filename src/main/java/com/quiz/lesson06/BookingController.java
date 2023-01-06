package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookingBO;
import com.quiz.lesson06.model.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {
	
	@Autowired
	private BookingBO bookingBO;

	// 메인
	// http://localhost/booking/main
	@GetMapping("/main")
	public String main_view() {
		return "lesson06/booking/main";
	}
	
	// 예약조회
	@ResponseBody
	@PostMapping("/main/CheckReservation")
	public Map<String,Object> CheckReservation(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		Map<String,Object> bookingResult = new HashMap<>();
		
		// DB 이름, 전화번호로 조회
		Booking checkedBooking = bookingBO.getBooking(name, phoneNumber);
		
		if(checkedBooking != null) {
			System.out.println(checkedBooking);
			bookingResult.put("result",1);	//성공
			bookingResult.put("checkResult",checkedBooking);
		}else {
			bookingResult.put("result",500);	//실패
			bookingResult.put("checkResult","조회실패");
		}
		
		
		return bookingResult;
	}
	
	
	
	// 예약목록 페이지
	// http://localhost/booking/reservation_view
	@GetMapping("/reservation_view")
	public String reservation_view(Model model) {
		
		//db select
		List<Booking> bookingList = bookingBO.getBookingList();
		System.out.println(bookingList);
		
		//model
		model.addAttribute("bookingList", bookingList);
		
		return "lesson06/booking/reservation_list";
	}
	
	//삭제
	@ResponseBody
	@DeleteMapping("/reservation_del")
	public Map<String,Object> reservation_del(
			@RequestParam("id") int id) {
		
		Map<String,Object> result = new HashMap<>();
		
		// db : 삭제
		int row = bookingBO.deleteBookingById(id);
		System.out.println(row);
		
		if (row>0) {	//성공시
			result.put("code", 0);	
			result.put("result", "성공");
		}else {		//실패시
			result.put("code", 500);
			result.put("result", "실패");
		}
		
		return result;
	}
	
	// 예약하기 페이지
	// http://localhost/booking/booking_view
	@GetMapping("/booking_view")
	public String booking_page() {
		return "lesson06/booking/booking_page";
	}
	
	// 예약
	@ResponseBody
	@PostMapping("/booking_reserve")
	public Map<String,Integer> booking_reserve(
			@ModelAttribute Booking booking) {
		
		booking.setState("대기중");
		System.out.println(booking);
		
		Map<String,Integer> result = new HashMap<>();
		
		// db insert
		int row = bookingBO.addBooking(booking);
		
		// ajax로 보내기
		result.put("result", row);
		
		return result;
	}
	
	
	
}
