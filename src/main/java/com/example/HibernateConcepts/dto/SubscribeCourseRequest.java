package com.example.HibernateConcepts.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscribeCourseRequest {
    private Long personId;
    private Long courseId;
}
