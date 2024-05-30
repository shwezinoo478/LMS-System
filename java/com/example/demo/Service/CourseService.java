package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Course;



public interface CourseService {
	Boolean CreateCourse(Course course);
	
	Course GetBycourseId(String courseId);
	
	List<Course> GetAllCourse();
	
	Boolean UpdateCourse(Course course);
	
	Boolean DeleteCourse(String courseId);
}
