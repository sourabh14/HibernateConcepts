package com.example.HibernateConcepts.dto;

import com.example.HibernateConcepts.entity.Passport;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassportDTO {
    private Long id;
    private String name;
    private String person;

    public PassportDTO(Passport passport) {
        this.id = passport.getId();
        this.name = passport.getName();
        this.person = passport.getPerson().getName();
    }
}
