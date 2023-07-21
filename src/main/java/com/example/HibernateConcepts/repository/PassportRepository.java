package com.example.HibernateConcepts.repository;

import com.example.HibernateConcepts.entity.person.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long>  {
}
