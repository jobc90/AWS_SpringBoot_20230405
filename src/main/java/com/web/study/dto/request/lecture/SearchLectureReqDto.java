package com.web.study.dto.request.lecture;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SearchLectureReqDto {
	
	@Min(value = 1)
	@Max(value = 2)
	private int type;
	
	@NotBlank(message = "강의이름 또는 강사이름을 입력하세요!!!")
	private String searchValue;

}
