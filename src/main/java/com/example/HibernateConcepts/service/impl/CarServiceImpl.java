package com.example.HibernateConcepts.service.impl;

import java.util.Optional;

import com.example.HibernateConcepts.entity.automobile.Car;
import com.example.HibernateConcepts.repository.CarRepository;
import com.example.HibernateConcepts.service.CarService;
import lombok.AllArgsConstructor;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    private SessionFactory sessionFactory;

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car getCarById(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        return optionalCar.get();
    }

    @Override
    @Transactional(readOnly = true)
    public Car getCarByIdByHibernateQuery(Long id) {
        Query query = sessionFactory.openSession().createQuery("select c from Car c join fetch c.tyre where c.id = :id");
        query.setParameter("id", id);
        return (Car) query.uniqueResult();
    }

}
