package com.example.HibernateConcepts.controller;

import com.example.HibernateConcepts.dto.PassportDTO;
import com.example.HibernateConcepts.entity.Car;
import com.example.HibernateConcepts.entity.Passport;
import com.example.HibernateConcepts.entity.Person;
import com.example.HibernateConcepts.service.CarService;
import com.example.HibernateConcepts.service.PersonPassportService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/person")
public class PersonPassportController {

    private PersonPassportService personPassportService;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person createdPerson = personPassportService.createPerson(person);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id) {
        Person person = personPassportService.getPersonById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("passport/{id}")
    public ResponseEntity<PassportDTO> getPassportById(@PathVariable("id") Long id) {
        Passport passport = personPassportService.getPassportById(id);
        PassportDTO passportDTO = new PassportDTO(passport);
        return new ResponseEntity<>(passportDTO, HttpStatus.OK);
    }

}
