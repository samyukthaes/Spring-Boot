package com.UST.College.controller;

import com.UST.College.entity.CollegeInfo;
import com.UST.College.entity.Departments;
import com.UST.College.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    public CollegeService collegeservice;

    @PostMapping("/add")
    public CollegeInfo addCollege(@RequestBody CollegeInfo collegeinfo){
        return collegeservice.addcollege(collegeinfo);
    }

    @GetMapping("/colleges")
    public List<CollegeInfo> getCollege(){
        return collegeservice.getAllCollege();
    }

    @GetMapping("/{id}")
    public CollegeInfo getCollegeById(@PathVariable int id){
        return collegeservice.getCollegeById(id);
    }

    @GetMapping("/find/{collegeName}")
    public CollegeInfo getBycollegeName(@PathVariable String collegeName){
        return collegeservice.getBycollegeName(collegeName);
    }

    @PutMapping("/{id}")
    public CollegeInfo updateCollegeById(@RequestBody CollegeInfo college){
        return collegeservice.updateByCollegeId(college);
    }

    @DeleteMapping("/{id}")
    public String deleteCollege(@PathVariable int id){
        return collegeservice.deleteCollegeById(id);
    }

    @PostMapping("/department")
    public Departments addDept(@RequestBody Departments dept){
        return collegeservice.addDepts(dept);
    }

    @PostMapping("/department/{id}")
    public CollegeInfo addDepttoClg(@PathVariable int id){
        return collegeservice.addDeptByid(id);
    }



}

