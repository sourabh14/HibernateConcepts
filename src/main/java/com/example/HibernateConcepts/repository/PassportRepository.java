package com.example.HibernateConcepts.repository;

import com.example.HibernateConcepts.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport, Long>  {
}
