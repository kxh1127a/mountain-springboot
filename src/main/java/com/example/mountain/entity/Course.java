package com.example.mountain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(nullable = false, name= "mountainId")
    @ManyToOne(fetch= FetchType.EAGER)
    private Mountain mountain;

    @Column(nullable= false)
    private String name;

    @Column(nullable= false)
    private Double distance;

    @Column(nullable = false)
    private Integer time;
}
