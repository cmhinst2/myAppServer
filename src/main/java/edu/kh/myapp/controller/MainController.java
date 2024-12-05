package edu.kh.myapp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin : Spring에서 제공하는 어노테이션으로 CORS 설정을 위해 사용됨

// CORS (Cross-Origin Resource Sharing)
// 클라이언트와 서버가 서로 다른 출처(origin)에서 요청을 주고 받을때 발생하는 보안 정책

// 브라우저에서는 기본적으로 다른출처(도메인, 프로토콜, 포트)의 요청을 차단함.

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MainController {
	
	@GetMapping("getPortNumber")
	public List<String> getPortNumber() {
		return Arrays.asList("서버포트는 80", "리액트포트는 3000");
	}
	
	@PostMapping("getUserInfo")
	public String getUserInfo(@RequestBody Map<String, Object> map) {
		// message 리턴
		// 만약에 요청데이터 중 name값이 홍길동이고, age값이 20이면
		// "홍길동 님은 20세 입니다" 리턴
		// 같지않다면 "데이터가 없습니다" 리턴
		System.out.println(map.get("name")); // 홍길동
		System.out.println(map.get("age")); // 20
		
		String message = "데이터가 없습니다";
		
		if(map.get("name").equals("홍길동") && map.get("age").equals(20)) {
			message = "홍길동님은 20세 입니다";
		}
		
		return message;
		
	}
	
}





