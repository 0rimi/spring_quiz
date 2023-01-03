package com.quiz.lesson05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson05.bo.WeatherBO;
import com.quiz.lesson05.model.Weather;

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

}
