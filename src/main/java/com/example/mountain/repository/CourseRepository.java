package com.example.mountain.repository;

import com.example.mountain.entity.Course;
import com.example.mountain.model.CourseItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByDistanceLessThanEqual (Integer km);
}
