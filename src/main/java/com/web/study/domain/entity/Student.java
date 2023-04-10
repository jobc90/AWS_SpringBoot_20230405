package com.web.study.domain.entity;

import java.time.LocalDate;

import org.apache.ibatis.type.Alias;

import com.web.study.dto.response.LecturerRespDto;
import com.web.study.dto.response.StudentRespDto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Student {
	private int id;
	private String name;
	private LocalDate birth_date;
	
	public StudentRespDto toDto() {
		return StudentRespDto.builder()
				.id(id)
				.name(name)
				.birthDate(birth_date)
				.build();
	}

}
