package com.example.HibernateConcepts.service.impl;

import java.util.Optional;

import com.example.HibernateConcepts.entity.Car;
import com.example.HibernateConcepts.repository.CarRepository;
import com.example.HibernateConcepts.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car getCarById(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        return optionalCar.get();
    }

}
