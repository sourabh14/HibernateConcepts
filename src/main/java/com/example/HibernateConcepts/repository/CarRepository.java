package com.example.HibernateConcepts.repository;

import com.example.HibernateConcepts.entity.automobile.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
