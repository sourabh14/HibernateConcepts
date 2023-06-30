package com.example.HibernateConcepts.repository;

import com.example.HibernateConcepts.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
