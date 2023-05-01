package com.javatechie.jpastreamer.repository;

import com.javatechie.jpastreamer.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
