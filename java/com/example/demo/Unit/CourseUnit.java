package com.example.demo.Unit;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Controller.CourseController;
import com.example.demo.Entity.Course;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/course")
public class CourseUnit {
	@Autowired CourseController courseController;
	 
	@GetMapping("/test")
	public HashMap<String,List<Course>> test() {
		HashMap<String,List<Course>> hashMap = new HashMap<String,List<Course>>();
		hashMap.put("course",courseController.GetAllCourse());
		return hashMap;
	}
	
	
	
}
