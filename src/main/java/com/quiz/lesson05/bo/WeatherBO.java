package com.quiz.lesson05.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson05.dao.WeatherDAO;
import com.quiz.lesson05.model.Weather;

@Service
public class WeatherBO {
	
	@Autowired
	private WeatherDAO weatherDAO;
	
	
	// selectAll
	public List<Weather> getWeatherList(){
		return weatherDAO.selectWeatherList();
	}
	
	//insert
	public void addWeatherHistory(String date,String weather,String microDust,double temperatures
			,double precipitation,double windSpeed) {
		weatherDAO.insertWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
	}

}
