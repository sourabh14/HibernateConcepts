package com.example.HibernateConcepts.service;

import java.util.List;

import com.example.HibernateConcepts.entity.Employee;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Employee employee);

    void deleteEmployeeById(Long id);

}
