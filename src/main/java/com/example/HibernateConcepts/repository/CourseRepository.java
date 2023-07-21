package com.example.HibernateConcepts.repository;

import com.example.HibernateConcepts.entity.person.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
