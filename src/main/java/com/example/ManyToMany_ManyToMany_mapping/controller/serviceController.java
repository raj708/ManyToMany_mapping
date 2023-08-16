package com.example.ManyToMany_ManyToMany_mapping.controller;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ManyToMany_ManyToMany_mapping.entity.Course;
import com.example.ManyToMany_ManyToMany_mapping.entity.Student;
import com.example.ManyToMany_ManyToMany_mapping.repository.CourseRepository;
import com.example.ManyToMany_ManyToMany_mapping.repository.StudentRepository;

@RestController
public class serviceController {
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	StudentRepository studentRepository;
	
	
	@GetMapping("/student")
	List<Student> student(){
		System.out.println();
		return studentRepository.findAll();
	}
	@GetMapping("/course")
	List<Course> cousrse(){
		
		return courseRepository.findAll();
	}
	@PostMapping("/addStudent")
	Student addStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@PostMapping("/addCourse")
	Course addStudent(@RequestBody Course course) {
		
		return courseRepository.save(course);
	}
	@GetMapping("/student/{id}")
	Student students(@PathVariable("id") int id){
		return studentRepository.findById(id).get();
	}
	@GetMapping("/course/{id}")
	Course course(@PathVariable("id")int id) {
		return courseRepository.findById(null).get();
	}
	@GetMapping("/student/{id}/courses")
	Set<Course> getCourseForStudent(@PathVariable("id")int id){
		Student student=studentRepository.findById(id).get();
		return student.getCourses();
	}
	
}
