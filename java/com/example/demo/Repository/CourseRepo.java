package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.Course;


public interface CourseRepo extends JpaRepository<Course, String>{

}
