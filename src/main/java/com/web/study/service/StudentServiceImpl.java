package com.web.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.web.study.dto.request.student.StudentReqDto;
import com.web.study.dto.response.InstructorRespDto;
import com.web.study.dto.response.StudentRespDto;
import com.web.study.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;
	
	@Override
	public void registeStudent(StudentReqDto studentReqDto) {
		studentRepository.saveStudent(studentReqDto.toEntity());
		
	}
	
	@Override
	public List<StudentRespDto> getStudentAll() {
		List<StudentRespDto> dtos = new ArrayList<>();
		
		studentRepository.getStudentAll().forEach(entity -> {
			dtos.add(entity.toDto());
		});
		return dtos;
	}
	
	@Override
	public StudentRespDto findStudentById(int id) {
//		try {
//			if(instructorRepository.findInstructorById(id) == null) {
//				throw new RuntimeException("존재하지 않는 id입니다");
//			}
//		} catch (Exception e) {
//			
//		}
		
		
		return studentRepository.findStudentById(id).toDto();
	}
	
	

}
