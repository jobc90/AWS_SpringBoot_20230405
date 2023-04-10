package com.web.study.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.web.study.domain.entity.Lecture;
import com.web.study.domain.entity.Lecturer;


@Mapper
public interface LectureRepository {
	//insert update delete는 return type이 개수로 정해져있다 그래서 int
	public int registe(Lecture lecture);
	public List<Lecture> getLectureAll();
	public Lecture findLectureById(int id);

}
