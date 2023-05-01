package com.UST.College.repository;


import com.UST.College.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepo extends JpaRepository<Departments,Integer> {




    Departments findByid(int id);
}
