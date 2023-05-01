package com.example.CarDemo.service;

import com.example.CarDemo.entity.Car;
import com.example.CarDemo.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarService {
    @Autowired
    public CarRepo carRepo;

    public Car addCarDetails(Car car) {
        return carRepo.save(car);

    }

    public List<Car> getAllDetails() {
        return carRepo.findAll();
    }


    public List<Car> findAllDetailsByDate(String availabilityDate) {
        return carRepo.findByavailabilityDate(availabilityDate);
    }
}
