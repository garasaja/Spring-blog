package com.cos.blog.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonRespDto<T> {
	private int statusCode; //1:정상 -1:실패, 0:변경안됨
	private T data;
}
