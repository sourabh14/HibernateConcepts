package com.example.HibernateConcepts.service.impl;

import java.util.Optional;

import com.example.HibernateConcepts.entity.Passport;
import com.example.HibernateConcepts.entity.Person;
import com.example.HibernateConcepts.repository.PassportRepository;
import com.example.HibernateConcepts.repository.PersonRepository;
import com.example.HibernateConcepts.service.PersonPassportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonPassportServiceImpl implements PersonPassportService {

    private PersonRepository personRepository;

    private PassportRepository passportRepository;

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Passport createPassport(Passport passport) {
        return passportRepository.save(passport);
    }

    @Override
    public Person getPersonById(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        return optionalPerson.get();
    }

    @Override
    public Passport getPassportById(Long id) {
        Optional<Passport> optionalPassport = passportRepository.findById(id);
        return optionalPassport.get();
    }

}
