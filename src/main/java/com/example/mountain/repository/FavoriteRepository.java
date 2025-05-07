package com.example.mountain.repository;

import com.example.mountain.entity.Course;
import com.example.mountain.entity.Favorite;
import com.example.mountain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    Optional<Favorite> findByUsersAndCourse(Users users, Course course);

}
