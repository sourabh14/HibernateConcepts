package com.example.HibernateConcepts.repository;

import com.example.HibernateConcepts.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
