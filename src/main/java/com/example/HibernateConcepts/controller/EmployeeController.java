package com.example.HibernateConcepts.controller;

import java.util.List;

import com.example.HibernateConcepts.entity.Employee;
import com.example.HibernateConcepts.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> Employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(Employees, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long employeeId,
                                           @RequestBody Employee employee) {
        employee.setId(employeeId);
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    // Build Delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployeeById(employeeId);
        return new ResponseEntity<>("Employee successfully deleted!", HttpStatus.OK);
    }
}
