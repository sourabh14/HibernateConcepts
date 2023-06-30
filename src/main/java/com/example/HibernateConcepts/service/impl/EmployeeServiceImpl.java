package com.example.HibernateConcepts.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.HibernateConcepts.entity.Employee;
import com.example.HibernateConcepts.repository.EmployeeRepository;
import com.example.HibernateConcepts.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
