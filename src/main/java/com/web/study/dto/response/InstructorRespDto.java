package com.web.study.dto.response;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class InstructorRespDto {
	private int instructorId;
	private String name;
	private LocalDate birthDate;

}
