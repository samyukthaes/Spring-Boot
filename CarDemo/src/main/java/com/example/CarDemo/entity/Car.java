package com.example.CarDemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
    @Id
    @GeneratedValue
    private Integer carId;
    private String carName;
    private Integer price;
    private String brand;
    private String color;
    private Integer noOfSeats;
    private String availabilityDate;
    private String status;


}
