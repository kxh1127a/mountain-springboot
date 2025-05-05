package com.example.mountain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseCreateRequest {
    private String mountainName;
    private String name;
    private Double distance;
    private Integer time;
}
