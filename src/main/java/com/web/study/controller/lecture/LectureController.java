package com.web.study.controller.lecture;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.aop.annotation.ValidAspectTest;
import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.lecture.LectureReqDto;
import com.web.study.dto.request.lecture.SearchLectureReqDto;
import com.web.study.service.LectureService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LectureController {
	
	private final LectureService lectureService;
	
	// Create
	@PostMapping("/lecture")
	public ResponseEntity<? extends ResponseDto> register(@RequestBody LectureReqDto lectureReqDto) {
		
		lectureService.registeLecture(lectureReqDto);
		
		return ResponseEntity.ok().body(ResponseDto.ofDefault());
	}
	
	// Read
	@GetMapping("/lectures")
	public ResponseEntity<? extends ResponseDto> getLectures() {
		
		return ResponseEntity.ok().body(DataResponseDto.of(lectureService.getLectureAll()));

	}
	
//	@GetMapping("/lecture/{id}")
//	public ResponseEntity<? extends ResponseDto> getLectureById(@PathVariable int id) {
//		
//		return ResponseEntity.ok().body(DataResponseDto.of(lectureService.findLectureById(id)));
//
//	}
	@ValidAspectTest
	@GetMapping("/search/lectures")
	public ResponseEntity<? extends ResponseDto> searchLectures(@Valid SearchLectureReqDto searchLectureReqDto, BindingResult bindingResult) {
		
		return ResponseEntity.ok().body(DataResponseDto.of(lectureService.searchLecture(searchLectureReqDto.getType(), searchLectureReqDto.getSearchValue())));

	}
	
	// Update
	public ResponseEntity<? extends ResponseDto> modify() {
		return ResponseEntity.ok().body(ResponseDto.ofDefault());
	}	
	
	// Delete
	public ResponseEntity<? extends ResponseDto> remove() {
		return ResponseEntity.ok().body(ResponseDto.ofDefault());
	}
}
