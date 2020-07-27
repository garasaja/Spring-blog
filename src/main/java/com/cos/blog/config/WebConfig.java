package com.cos.blog.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cos.blog.config.aop.RoleIntercepter;
import com.cos.blog.config.aop.SessionIntercepter;

//필터링
@Configuration
public class WebConfig implements WebMvcConfigurer{

	//인터셉터 : 컨트롤러 접근하기 전에 인증 및 권한 확인 후 보내기 위함
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//인증
		registry.addInterceptor(new SessionIntercepter()).addPathPatterns("/user/**").addPathPatterns("/post/**").addPathPatterns("/post**");
		//인증 + 권한
		registry.addInterceptor(new RoleIntercepter()).addPathPatterns("/admin/**");
		
		
		
	}
}
