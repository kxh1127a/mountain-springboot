package com.example.mountain.service;

import com.example.mountain.entity.Course;
import com.example.mountain.entity.Mountain;
import com.example.mountain.model.CourseCreateRequest;
import com.example.mountain.model.CourseItem;
import com.example.mountain.model.CourseNameUpdateRequest;
import com.example.mountain.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

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

    public List<CourseItem> getCourses() {
        List<Course> target = courseRepository.findAll();
        List<CourseItem> result = new LinkedList<>();

        target.forEach(item->{
           CourseItem courseItem = new CourseItem();
           courseItem.setId(item.getId());
           courseItem.setMountainInfo("No."+ item.getMountain().getId()+ " " + item.getMountain().getName()+ " mountain");
           courseItem.setCourseInfo(item.getName() + " / " + item.getDistance() + "km / " + item.getTime() +" hours");
           result.add(courseItem);
        });
        return result;
    }


    public List<CourseItem> getCourse(long id) {
        List<Course> target = courseRepository.findAll();
        List<CourseItem> result = new LinkedList<>();

        target.forEach(item->{
            if(item.getMountain().getId() == id) {
                CourseItem courseItem = new CourseItem();
                courseItem.setId(item.getId());
                courseItem.setMountainInfo("No." + item.getMountain().getId() + " " + item.getMountain().getName() + " mountain");
                courseItem.setCourseInfo(item.getName() + " / " + item.getDistance() + "km / " + item.getTime() + " hours");
                result.add(courseItem);
            }
        });
        return result;
    }


    public void putCourseByName(long id, CourseNameUpdateRequest request) {
        Course target = courseRepository.findById(id).orElseThrow();
        target.setName(request.getName());
        courseRepository.save(target);
    }

    public void delCourse(long id) {
        courseRepository.deleteById(id);
    }


    public List<CourseItem> getLowerSorting(Integer km) {
        List<Course> target = courseRepository.findAllByDistanceLessThanEqual(km);

        List<CourseItem> result = new LinkedList<>();

        target.forEach(item->{
            CourseItem courseItem = new CourseItem();
            courseItem.setId(item.getId());
            courseItem.setMountainInfo("No."+ item.getMountain().getId()+ " " + item.getMountain().getName()+ " mountain");
            courseItem.setCourseInfo(item.getName() + " / " + item.getDistance() + "km / " + item.getTime() +" hours");
            result.add(courseItem);
        });
        return result;
    }


    public Course getCourseInfo(Long courseId) {
        return courseRepository.findById(courseId).orElseThrow();
    }
}
