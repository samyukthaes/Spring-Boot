package com.UST.College.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "department")
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;
    private int id;
    private String departmentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "college_id",referencedColumnName = "id")
    @JsonIgnore
    private CollegeInfo collegeinfo;

}
