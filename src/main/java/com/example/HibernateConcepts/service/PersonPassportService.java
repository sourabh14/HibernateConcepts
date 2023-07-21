package com.example.HibernateConcepts.service;

import java.util.List;

import com.example.HibernateConcepts.dto.UpdatePersonNameRequest;
import com.example.HibernateConcepts.entity.person.Passport;
import com.example.HibernateConcepts.entity.person.Person;

public interface PersonPassportService {
    Person createPerson(Person person);

    Passport createPassport(Passport passport);

    Person getPersonById(Long id);

    Passport getPassportById(Long id);

    List<Person> getAllPerson();

    Person updatePersonName(UpdatePersonNameRequest updatePersonNameRequest);

    Person getPersonByName(String name);
}
