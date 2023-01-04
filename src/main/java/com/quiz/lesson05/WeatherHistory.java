package com.quiz.lesson05;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson05.bo.WeatherBO;
import com.quiz.lesson05.model.Weather;

import jakarta.servlet.http.HttpServletResponse;

@RequestMapping("/lesson05")
@Controller
public class WeatherHistory {

	@Autowired
	private WeatherBO weatherBO;

	// http://localhost/lesson05/quiz05/weather_history
	@GetMapping("/quiz05/weather_history")
	public String quiz05_weather_history(Model model) {

		// list 출력
		List<Weather> weather = weatherBO.getWeatherList();
		// System.out.println(weather.toString());

		// model
		model.addAttribute("weathers", weather);
		model.addAttribute("add", "weather_history");

		return "lesson05/quiz05/main";
	}
	
	// http://localhost/lesson05/quiz05/add_weather
	@GetMapping("/quiz05/add_weather")
	public String quiz05_add_weather(Model model) {

		return "lesson05/quiz05/add_weather";
	}
	
	
	@PostMapping("/add_weather")
	public String addWeather(
			//@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date,	//String을 Date로 받아오기
			@RequestParam("date") String date, //String으로 인서트해도 DB에서는 date타입으로 잘 저장된다
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed,
			HttpServletResponse response){
			
		//db insert
		weatherBO.addWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
		
		//redirect
		//response.sendRedirect("/quiz05/weather_history");
		
		return "redirect:/lesson05/quiz05/weather_history";
	}

}
