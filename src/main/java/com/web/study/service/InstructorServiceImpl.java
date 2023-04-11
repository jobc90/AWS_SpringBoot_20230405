package com.web.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.web.study.dto.ErrorResponseDto;
import com.web.study.dto.request.instructor.InstructorReqDto;
import com.web.study.dto.response.InstructorRespDto;
import com.web.study.repository.InstructorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService{

	private final InstructorRepository instructorRepository;
	
	@Override
	public void registeInstructor(InstructorReqDto instructorReqDto) {
		instructorRepository.saveInstructor(instructorReqDto.toEntity());
		
	}

	@Override
	public List<InstructorRespDto> getInstructorAll() {
		List<InstructorRespDto> dtos = new ArrayList<>();
		
		instructorRepository.getInstructorAll().forEach(entity -> {
			dtos.add(entity.toDto());
		});
		return dtos;
	}
	
	@Override
	public InstructorRespDto findInstructorById(int id) {
//		try {
//			if(instructorRepository.findInstructorById(id) == null) {
//				throw new RuntimeException("존재하지 않는 id입니다");
//			}
//		} catch (Exception e) {
//			
//		}
		
		
		return instructorRepository.findInstructorById(id).toDto();
	}
		
	
}
