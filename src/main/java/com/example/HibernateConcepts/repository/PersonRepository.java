package com.example.HibernateConcepts.repository;

import com.example.HibernateConcepts.entity.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    // Dont use string concat to build query
    // - Named parameter prevents sql injection: https://mkyong.com/hibernate/hibernate-parameter-binding-examples/
    @Query("SELECT p FROM Person p WHERE p.name = :name")
    Person findByName(@Param("name") String name);
}
