package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Course;
import com.example.demo.Repository.CourseRepo;
import com.example.demo.Service.CourseService;

@Service
public class CourseController implements CourseService{

	@Autowired CourseRepo courseRepo ;

	@Override
	public Boolean CreateCourse(Course course) {
		courseRepo.save(course);
		return true;
	}

	@Override
	public Course GetBycourseId(String courseId) {
		Course c = new Course();
		c = courseRepo.findById(courseId).orElse(null);
		return c;
	}

	@Override
	public List<Course> GetAllCourse() {
		// TODO Auto-generated method stub
		return courseRepo.findAll();
	}

	@Override
	public Boolean UpdateCourse(Course course) {
		// TODO Auto-generated method stub
		courseRepo.save(course);
		return true;
	}

	@Override
	public Boolean DeleteCourse(String courseId) {
		// TODO Auto-generated method stub
		courseRepo.deleteById(courseId);
		return true;
	}
	
	

}
