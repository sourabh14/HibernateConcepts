package com.example.HibernateConcepts.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.HibernateConcepts.dto.UpdatePersonNameRequest;
import com.example.HibernateConcepts.entity.person.Passport;
import com.example.HibernateConcepts.entity.person.Person;
import com.example.HibernateConcepts.repository.PassportRepository;
import com.example.HibernateConcepts.repository.PersonRepository;
import com.example.HibernateConcepts.service.PersonPassportService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonPassportServiceImpl implements PersonPassportService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
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

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    @Transactional
    public Person updatePersonName(UpdatePersonNameRequest updatePersonNameRequest) {
        Person person = personRepository.findById(updatePersonNameRequest.getPersonId()).get();
        person.setName(updatePersonNameRequest.getName());
        System.out.println("Person updated");
        return person;
    }

    // JPQL
    @Override
    public Person getPersonByName(String name) {
        return personRepository.findByName(name);
    }

}
