package com.example.HibernateConcepts.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePersonNameRequest {
    private Long personId;
    private String name;
}
