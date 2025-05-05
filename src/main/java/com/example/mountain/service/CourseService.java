package com.example.mountain.service;

import com.example.mountain.entity.Course;
import com.example.mountain.entity.Mountain;
import com.example.mountain.model.CourseCreateRequest;
import com.example.mountain.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public void setCourse(long id, CourseCreateRequest request) {
        Course course = new Course();
        Mountain mountain = new Mountain();
        mountain.setId(id);
        mountain.setName(request.getMountainName());

        course.setMountain(mountain);
        course.setName(request.getName());
        course.setDistance(request.getDistance());
        course.setTime(request.getTime());

        courseRepository.save(course);
    }



}
