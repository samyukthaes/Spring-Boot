package com.example.NewStudent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String studentId;
    private String name;
    private String email;
    private String phnNo;
    private String Qualification;
    private String exp;
    @ElementCollection
    private List<String> interestedCourses;
    private String address;
    private String comments;


}

