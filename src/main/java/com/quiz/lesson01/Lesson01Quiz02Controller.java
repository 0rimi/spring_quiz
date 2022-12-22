package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/quiz02")
@RestController
public class Lesson01Quiz02Controller {
	
	@RequestMapping("/1")
	public List<Map<String,Object>> printListMap(){
		List<Map<String,Object>> movies = new ArrayList<>();
		
		Map<String,Object> mv = new HashMap<>();
		mv.put("rate", 15);
		mv.put("director", "봉준호");
		mv.put("time", 131);
		mv.put("title", "기생충");
		movies.add(mv);
		
		mv = new HashMap<>();
		mv.put("rate", 0);
		mv.put("director", "로베르토 베니니");
		mv.put("time", 116);
		mv.put("title", "인생은 아름다워");
		movies.add(mv);
		
		mv = new HashMap<>();
		mv.put("rate", 12);
		mv.put("director", "크리스토퍼 놀란");
		mv.put("time", 147);
		mv.put("title", "인셉션");
		movies.add(mv);
		
		mv = new HashMap<>();
		mv.put("rate", 19);
		mv.put("director", "윤종빈");
		mv.put("time", 133);
		mv.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		movies.add(mv);
		
		mv = new HashMap<>();
		mv.put("rate", 15);
		mv.put("director", "프란시스 로랜스");
		mv.put("time", 137);
		mv.put("title", "헝거게임");
		movies.add(mv);
		
		return movies;
	}
	
	@RequestMapping("/2")
	public List<Board> quiz02_2(){
		List<Board> boards = new ArrayList<>();
		Board board = new Board();
	
		board.setTitle("안녕하세요. 더보이즈의 영훈남 영훈입니다.");
		board.setUser("yh0808");
		board.setContent("더비~~ 으구 내 시끼들!! 오늘도 수고했어~ 빵담빵담 ㅎㄹㅅ~");
		boards.add(board);
		
		board = new Board();		
		board.setTitle("안녕하세요. 더보이즈의 선물 현재입니다.");
		board.setUser("jh0913");
		board.setContent("더비ㅋㅋ 하트해. 사랑한단 뜻이야 하트해가.");
		boards.add(board);
		
		board = new Board();		
		board.setTitle("안녕하세요. 더보이즈의 광합성 선우입니다.");
		board.setUser("sw0412");
		board.setContent("더비는 오늘 뭐했어. 내 생각했다고? 하 참 또 이러네.. 나도ㅋㅋ");
		boards.add(board);
		
		board = new Board();		
		board.setTitle("안녕하세요. 더보이즈의 주연 주연입니다.");
		board.setUser("jy0115");
		board.setContent("더비덕분에 오늘 힘냈어. 아이스크림 먹어야지. 오늘은 찰옥수수다.");
		boards.add(board);
		
		return boards;
	}
	
	@RequestMapping("/3")
	public ResponseEntity<Board> quiz02_3(){
	
		Board board = new Board();
		
		board.setTitle("안녕하세요. 더보이즈의 영훈남 영훈입니다.");
		board.setUser("yh0808");
		board.setContent("더비~~ 으구 내 시끼들!! 오늘도 수고했어~ 빵담빵담 ㅎㄹㅅ~");
		
		return new ResponseEntity<>(board,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
