package com.web.study.repository;

import org.apache.ibatis.annotations.Mapper;

import com.web.study.domain.entity.Lecture;

@Mapper
public interface LectureRepository {
	//insert update delete는 return type이 개수로 정해져있다 그래서 int
	public int registe(Lecture lecture);

}
