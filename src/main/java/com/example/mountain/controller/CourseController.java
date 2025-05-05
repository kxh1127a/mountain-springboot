package com.example.mountain.controller;

import com.example.mountain.model.CourseCreateRequest;
import com.example.mountain.model.CourseItem;
import com.example.mountain.service.CourseService;
import com.example.mountain.service.MountainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;
    private final MountainService mountainService;

    @PostMapping("/new")
    public String setCourse(@RequestBody CourseCreateRequest request) {
        long id = mountainService.getMountainId(request.getMountainName());
        courseService.setCourse(id, request);

        return "success Create data!";
    }

    @GetMapping("/all")
    public List<CourseItem> getCourses() {
        return courseService.getCourses();
    }

    @GetMapping("/{id}") // mountain id
    public List<CourseItem> getCourse(@PathVariable long id) {
        return courseService.getCourse(id);
    }
}
