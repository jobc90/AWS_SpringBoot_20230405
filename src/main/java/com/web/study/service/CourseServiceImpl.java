package com.web.study.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import com.web.study.aop.annotation.ReturnDataAspect;
import com.web.study.domain.entity.Course;
import com.web.study.dto.request.course.CourseReqDto;
import com.web.study.dto.response.CourseRespDto;
import com.web.study.repository.CourseRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{
	
	private final CourseRepository courseRepository;

	@Override
	public void registeCourse(CourseReqDto courseReqDto) {
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
		
		Course course = courseReqDto.toEntity();
		courseRepository.registe(course);
		
//		stopWatch.stop();
//		System.out.println("메소드 실행 시간: " + stopWatch.getTotalTimeSeconds() + "초");
	}

	@Override
	public List<CourseRespDto> getCourseAll() {
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
		
		 List<CourseRespDto> dtos = new ArrayList<>();
		 courseRepository.getCourseAll().forEach(entity -> {
			 dtos.add(entity.toDto());
		 });
		 
//		stopWatch.stop();
//		System.out.println("메소드 실행 시간: " + stopWatch.getTotalTimeSeconds() + "초");
		 
		return dtos;
	}
	
	@ReturnDataAspect
	@Override
	public List<CourseRespDto> searchCourse(int type, String searchValue) {
		Map<String, Object> parameterMap = new HashMap<>();
		parameterMap.put("type", type);
		parameterMap.put("searchValue", searchValue);
		
		List<CourseRespDto> dtos = new ArrayList<>();
		courseRepository.searchCourse(parameterMap).forEach(entity -> {
			dtos.add(entity.toDto());
		});
		
		
		 
		return dtos;
	}


}
