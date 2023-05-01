package com.example.NewStudent.service;

import com.example.NewStudent.entity.Student;
import com.example.NewStudent.entity.Student$;
import com.example.NewStudent.exception.EmployeeAlreadyPresentException;
import com.example.NewStudent.repository.StudentRepo;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private JPAStreamer jpaStreamer;
    public Student addAllDetails(Student student) {
        return studentRepo.save(student);
    }


    public Long getDetailsByCourses(String interestedCourses) {
        Predicate<Student> courseFilter = student -> student.getInterestedCourses().contains(interestedCourses);
        return jpaStreamer.stream(Student.class)
                .filter(courseFilter)
                .count();
    }

    public List<Student> getListByAddress(String address) {
        return jpaStreamer.stream(Student.class)
                .filter(Student$.address.contains(address))
                .collect(Collectors.toList());
    }
}
