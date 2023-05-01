package com.example.NewStudent.controller;

import com.example.NewStudent.entity.Student;
import com.example.NewStudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/add")
    public Student addDetails(@RequestBody Student student){
        return studentService.addAllDetails(student);

    }
    @GetMapping("/{interestedCourses}")
    public long getCountByCourses(@PathVariable String interestedCourses){
        return studentService.getDetailsByCourses(interestedCourses);

    }
    @GetMapping("/emp/{address}")
    public List<Student> getByLocation(@PathVariable String address){
        return studentService.getListByAddress(address);
        }
    }









