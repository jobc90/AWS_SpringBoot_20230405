package com.web.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.web.study.dto.ErrorResponseDto;
import com.web.study.dto.request.lecturer.LecturerReqDto;
import com.web.study.dto.response.LecturerRespDto;
import com.web.study.repository.LecturerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LecturerServiceImpl implements LecturerService{

	private final LecturerRepository lecturerRepository;
	
	@Override
	public void registeLecturer(LecturerReqDto lecturerReqDto) {
		lecturerRepository.saveLecturer(lecturerReqDto.toEntity());
		
	}

	@Override
	public List<LecturerRespDto> getLecturerAll() {
		List<LecturerRespDto> dtos = new ArrayList<>();
		
		lecturerRepository.getLecturerAll().forEach(entity -> {
			dtos.add(entity.toDto());
		});
		return dtos;
	}
	
	@Override
	public LecturerRespDto findLecturerById(int id) {
//		try {
//			if(lecturerRepository.findLecturerById(id) == null) {
//				throw new RuntimeException("존재하지 않는 id입니다");
//			}
//		} catch (Exception e) {
//			
//		}
		
		
		return lecturerRepository.findLecturerById(id).toDto();
	}
		
	
}
