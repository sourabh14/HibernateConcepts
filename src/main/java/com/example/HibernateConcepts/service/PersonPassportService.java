package com.example.HibernateConcepts.service;

import com.example.HibernateConcepts.entity.Car;
import com.example.HibernateConcepts.entity.Passport;
import com.example.HibernateConcepts.entity.Person;

public interface PersonPassportService {
    Person createPerson(Person person);

    Passport createPassport(Passport passport);

    Person getPersonById(Long id);

    Passport getPassportById(Long id);
}
