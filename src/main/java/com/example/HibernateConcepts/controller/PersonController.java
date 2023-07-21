package com.example.HibernateConcepts.controller;

import java.util.List;

import com.example.HibernateConcepts.dto.GetPersonByNameRequest;
import com.example.HibernateConcepts.dto.PassportDTO;
import com.example.HibernateConcepts.dto.PersonDTO;
import com.example.HibernateConcepts.dto.SubscribeCourseRequest;
import com.example.HibernateConcepts.dto.UpdatePersonNameRequest;
import com.example.HibernateConcepts.entity.person.Course;
import com.example.HibernateConcepts.entity.person.EmailGroup;
import com.example.HibernateConcepts.entity.person.Passport;
import com.example.HibernateConcepts.entity.person.Person;
import com.example.HibernateConcepts.repository.CourseRepository;
import com.example.HibernateConcepts.repository.EmailGroupRepository;
import com.example.HibernateConcepts.service.PersonPassportService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonPassportService personPassportService;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EmailGroupRepository emailGroupRepository;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        System.out.println("Create Person Request : " + person);
        Person createdPerson = personPassportService.createPerson(person);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id) {
        Person person = personPassportService.getPersonById(id);
        System.out.println("Person: " + person.getName());
        System.out.println("    Address: " + person.getAddress());
        // One to many is lazy fetch by default
        System.out.println("    debitCards: " + person.getDebitCard());
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("passport/{id}")
    public ResponseEntity<PassportDTO> getPassportById(@PathVariable("id") Long id) {
        Passport passport = personPassportService.getPassportById(id);
        PassportDTO passportDTO = new PassportDTO(passport);
        return new ResponseEntity<>(passportDTO, HttpStatus.OK);
    }

    @PostMapping("course/subscribe")
    public ResponseEntity<String> subscribePersonToCourse(@RequestBody SubscribeCourseRequest subscribeCourseRequest) {
        Person person = personPassportService.getPersonById(subscribeCourseRequest.getPersonId());
        Course course = courseRepository.findById(subscribeCourseRequest.getCourseId()).get();
        person.addCourse(course);
        personPassportService.createPerson(person);
        // course.addPerson(person);        // We have cascade on so we don't need to do this
        // courseRepository.save(course);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    // Deletion in case of many to many bidirectional relationship

    @DeleteMapping("course/delete/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable("id") Long courseId){
        courseRepository.deleteById(courseId);
        // We have cascade type all (which includes REMOVE)
        // Therefore, this will also delete person_courses and associated person.
        // If the person to be deleted is again associated with some other course, then that course will also be deleted.
        return new ResponseEntity<>("Course successfully deleted!", HttpStatus.OK);
    }

    @DeleteMapping("emailgroup/delete/{id}")
    public ResponseEntity<String> deleteEmailGroupById(@PathVariable("id") Long emailGroupId){
        // On deleting email group, we want to
            // - delete emailGroup
            // - relationship with person
        // We don't want to delete associated person
        // We will first remove email groups from person then delete the email group
        EmailGroup emailGroupToBeRemoved = emailGroupRepository.findById(emailGroupId).get();

        List<Person> personList = personPassportService.getAllPerson();
        for (Person person : personList) {
            person.getEmailGroups().remove(emailGroupToBeRemoved);
            personPassportService.createPerson(person);
        }
        emailGroupRepository.delete(emailGroupToBeRemoved);
        return new ResponseEntity<>("Email Group successfully deleted!", HttpStatus.OK);
    }

    // Transactional demo
    /*
        https://thorben-janssen.com/transactions-spring-data-jpa/
     */
    @PostMapping("name/update")
    public ResponseEntity<String> updatePersonName(@RequestBody UpdatePersonNameRequest updatePersonNameRequest) {
        Person person = personPassportService.updatePersonName(updatePersonNameRequest);
        return new ResponseEntity<>("Person name updated successfully to " + person.getName(), HttpStatus.OK);
    }

    /*
        JPQL demo
            - jpql intro: https://www.baeldung.com/spring-data-jpa-query

     */
    @GetMapping("name")
    public ResponseEntity<Person> getPersonByName(@RequestBody GetPersonByNameRequest getPersonByNameRequest) {
        Person person = personPassportService.getPersonByName(getPersonByNameRequest.getName());
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

}
