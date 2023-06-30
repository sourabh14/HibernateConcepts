package com.example.HibernateConcepts.controller;

import com.example.HibernateConcepts.entity.Car;
import com.example.HibernateConcepts.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/car")
public class CarController {
    private CarService carService;

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        System.out.println("Request Create Car: " + car);
        Car savedCar = carService.createCar(car);
        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") Long id) {
        Car car = carService.getCarById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping("lazy/{id}")
    public ResponseEntity<Object> getCarByIdLazy(@PathVariable("id") Long id) {
        Car car = carService.getCarById(id);
        System.out.println("Car: ");
        System.out.println("    id: " + car.getId());
        System.out.println("    name: " + car.getName());
        System.out.println("    engine: " + car.getEngine());
        // When the getter is called for tyre, the hibernate will make db call at this point
        System.out.println("    tyre: " + car.getTyre());
        return new ResponseEntity<>("See logs", HttpStatus.OK);
    }

}
