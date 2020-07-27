package com.cos.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	//인증필요
	@GetMapping("/test/user/{id}")
	public String findUser() {
		return "<h1>유저찾기 페이지</h1>";
	}
	
	//인증필요x	
	@GetMapping("/test/post/{id}")
	public String findPost() {
		return "<h1>글 상세보기 페이지</h1>";
	}
	//인증필요 + 관리자 권한필요
	@GetMapping("/test/admin")
	public String admin() {
		return "<h1>관리자 페이지</h1>";
	}
}
