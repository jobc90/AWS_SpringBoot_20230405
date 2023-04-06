package com.web.study.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.BasicTestDto;
import com.web.study.dto.request.TestDto;

@RestController
public class TestController {
//	get요청
//	param 1개
//	param 여러개 -> Dto만들어서 1, Dto없이 1
	

	@GetMapping("/player")
	public ResponseEntity<? extends ResponseDto> player(String name) {
		
		return ResponseEntity.ok().body(DataResponseDto.of(name));
	}
	
	@GetMapping("/player2")
	public ResponseEntity<? extends ResponseDto> player2(int age, String name, String team) {
		
		String playerInfo = name + "(" + age + ", " + team + ")";
		
		return ResponseEntity.ok().body(DataResponseDto.of(playerInfo));
	}
	
	@GetMapping("/player3")
	public ResponseEntity<? extends ResponseDto> player3(TestDto testDto) {
		
		String playerInfo = testDto.getName() + "(" + testDto.getAge() + ", " + testDto.getTeam() + ")";
		
		return ResponseEntity.ok().body(DataResponseDto.of(playerInfo));
	}
	
//	
//	post요청
//	param 여러개 -> formData 1, JSON 1
	
	@PostMapping("/player/info/form")
	public ResponseEntity<? extends ResponseDto> playerInfoForm(TestDto testDto) {
		
		return ResponseEntity.created(null).body(DataResponseDto.of(testDto));
	}
	
	@PostMapping("/player/info/json")
	public ResponseEntity<? extends ResponseDto> playerInfoJson(@RequestBody TestDto testDto) {
		
		return ResponseEntity.created(null).body(DataResponseDto.of(testDto));
	}

}
