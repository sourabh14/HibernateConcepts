package com.example.HibernateConcepts.repository;

import com.example.HibernateConcepts.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
