package com.example.CarDemo.controller;

import com.example.CarDemo.entity.Car;
import com.example.CarDemo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sharathcars")
public class CarController {
    @Autowired
    public CarService carService;
    @PostMapping("/cars")
    public Car addDetails(@RequestBody Car car){
        return carService.addCarDetails(car);

    }
    @GetMapping("/all")
    public List<Car> getDetails(){
        return carService.getAllDetails();

    }
    @GetMapping("/{availabilityDate}")
    public List<Car> getDetailsByDate(@PathVariable String availabilityDate){
        return carService.findAllDetailsByDate(availabilityDate);

    }

}
