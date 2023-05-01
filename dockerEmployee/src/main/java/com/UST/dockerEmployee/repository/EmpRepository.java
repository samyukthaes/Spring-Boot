package com.UST.dockerEmployee.repository;

import com.UST.dockerEmployee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpRepository extends JpaRepository<Employee,String> {
    Employee findByempId(String empid);


    void deleteByempId(String empId);
}
