package com.UST.College.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "college")
public class CollegeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String collegeName;

    @OneToMany(mappedBy = "collegeinfo",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Departments> department;


    public CollegeInfo(int id, String collegeName) {
    }
}
