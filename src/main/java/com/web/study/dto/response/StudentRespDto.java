package com.web.study.dto.response;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StudentRespDto {
	private int studentId;
	private String name;
	private LocalDate birthDate;

}
