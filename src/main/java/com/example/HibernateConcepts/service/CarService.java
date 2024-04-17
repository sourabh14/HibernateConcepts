package com.example.HibernateConcepts.service;

import com.example.HibernateConcepts.entity.automobile.Car;

public interface CarService {

    Car createCar(Car car);

    Car getCarById(Long id);

    Car getCarByIdByHibernateQuery(Long id);
}
