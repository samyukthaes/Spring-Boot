package com.example.CarDemo.repository;

import com.example.CarDemo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface CarRepo extends JpaRepository<Car,Integer> {





    List<Car> findByavailabilityDate(String availabilityDate);
}
