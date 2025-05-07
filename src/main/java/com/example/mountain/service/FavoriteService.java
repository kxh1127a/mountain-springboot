package com.example.mountain.service;

import com.example.mountain.entity.Course;
import com.example.mountain.entity.Favorite;
import com.example.mountain.entity.Users;
import com.example.mountain.repository.FavoriteRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;

    public void setFavorite(Course course, Users users) {
        if(!favoriteRepository.findByUsersAndCourse(users, course).isPresent()) {
            Favorite favorite = new Favorite();
            favorite.setUsers(users);
            favorite.setCourse(course);

            favoriteRepository.save(favorite);
        } else {
            favoriteRepository.deleteById(favoriteRepository.findByUsersAndCourse(users, course).get().getId());
        }
    }

    public String getFavorite(long id) {
        List<Favorite> target = favoriteRepository.findAll();
        StringBuilder str = new StringBuilder();

        target.forEach(item -> {
            if(item.getUsers().getId() == id) {
                str.append(item.getCourse().getMountain().getName()+"산의 " + item.getCourse().getName() +"코스를 즐겨찾기 중입니다.\n");
            }
        });

        return str.toString();
    }
}
