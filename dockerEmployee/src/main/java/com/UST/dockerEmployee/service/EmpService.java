package com.UST.dockerEmployee.service;

import com.UST.dockerEmployee.entity.Employee;
import com.UST.dockerEmployee.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
    @Service
    public class EmpService {

        @Autowired
        public EmpRepository repo;

        public Employee addNewEmp(Employee emp) {
            return repo.save(emp);
        }

        public List<Employee> getAllEmpss() {
            return repo.findAll();
        }

        public Employee getEmpsByempId(String empId) {
            return repo.findByempId(empId);
        }

        @Transactional
        public String deleteEmpsByempId(String empId) {
            repo.deleteByempId(empId);
            return "Employee Deleted...";
        }
    }


