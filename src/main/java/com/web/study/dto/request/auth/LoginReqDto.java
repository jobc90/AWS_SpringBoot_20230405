package com.web.study.dto.request.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.web.study.domain.entity.User;

import lombok.Data;

@Data
public class LoginReqDto {
	private String username;
	private String password;
	
	public User toEntity() {
		return User.builder()
				.username(username)
				.password(new BCryptPasswordEncoder().encode(password))
				.build();
	}	

}
