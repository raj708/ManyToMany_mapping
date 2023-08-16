package com.example.ManyToMany_ManyToMany_mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ManyToMany_ManyToMany_mapping.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	

}
