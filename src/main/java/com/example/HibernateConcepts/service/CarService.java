package com.example.HibernateConcepts.service;

import com.example.HibernateConcepts.entity.Car;

public interface CarService {

    Car createCar(Car car);

    Car getCarById(Long id);

}
