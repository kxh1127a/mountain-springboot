package com.example.mountain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(nullable = false, name="courseId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Course course;

    @JoinColumn(nullable = false, name="usersId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Users users;

}
