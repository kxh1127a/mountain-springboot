package com.example.mountain.controller;

import com.example.mountain.entity.Course;
import com.example.mountain.entity.Users;
import com.example.mountain.service.CourseService;
import com.example.mountain.service.FavoriteService;
import com.example.mountain.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/favorite")
public class FavoriteController {
    private final CourseService courseService;
    private final UsersService usersService;
    private final FavoriteService favoriteService;

    @PostMapping("/new")
    public String setFavorite(@RequestParam Long courseId,
                              @RequestParam Long usersId) {

        Users users = usersService.getUsersInfo(usersId);
        Course course = courseService.getCourseInfo(courseId);
        favoriteService.setFavorite(course, users);
        return "";

    }

    @GetMapping("/{id}")
    private String getFavorite(@PathVariable long id) {
        return favoriteService.getFavorite(id);
    }
}
