package com.web.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.BasicTestDto;


@RestController
public class BasicRestConroller {
	
	
	// Get 요청의 param을 처리하는 방법
	@GetMapping("/read")
	// extends ResponseDto는 응답하는 데이터의 상태를 설정해준다.
	public ResponseEntity<? extends ResponseDto> read(BasicTestDto basicTestDto) {
		
		String userInfo = basicTestDto.getName() + "(" + basicTestDto.getAge() + ")";
		
		return ResponseEntity.ok().body(DataResponseDto.of(userInfo));
	}
	
	@GetMapping("/read2/{id}")
//	public ResponseEntity<? extends ResponseDto> read2(@PathVariable("id") int userId) {
	public ResponseEntity<? extends ResponseDto> read2(@PathVariable int id) {
		Map<Integer, String> userMap = new HashMap<>();
		
		userMap.put(1, "이강인");
		userMap.put(2, "손흥민");
		userMap.put(3, "황희찬");
		userMap.put(4, "이재성");
		userMap.put(5, "김민재");
		
		return ResponseEntity.ok().body(DataResponseDto.of(userMap.get(id)));
	}
	
	// Post요청의 데이터 처리
	@PostMapping("/create")
	// Form을 받을 땐 @RequestBody가 있으면 415 error(데이터 형식이 잘못됨)가 뜬다.
	// Json을 받을 땐 @RequestBody를 붙여준다
	public ResponseEntity<? extends ResponseDto> create(@RequestBody BasicTestDto basicTestDto) {
		System.out.println("데이터 추가");
		
		return ResponseEntity.created(null).body(DataResponseDto.of(basicTestDto));
	}

}
