package com.UST.College.service;


import com.UST.College.entity.CollegeInfo;
import com.UST.College.entity.Departments;
import com.UST.College.repository.CollegeRepo;
import com.UST.College.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CollegeService {

    @Autowired
    public CollegeRepo repo;

    @Autowired
    public DepartmentRepo deptrepo;

    public CollegeInfo addcollege(CollegeInfo collegeinfo) {

        repo.save(collegeinfo);
        Departments dept = deptrepo.findByid(collegeinfo.getId());
        collegeinfo.getDepartment().add(dept);
        return repo.save(collegeinfo);
    }

    public List<CollegeInfo> getAllCollege() {
        return repo.findAll();
    }

    public CollegeInfo getCollegeById(int id) {
        return repo.findById(id).orElse(null);
    }
    public CollegeInfo getBycollegeName(String collegeName) {
        CollegeInfo collegeinfo =  repo.findBycollegeName(collegeName);
        return new CollegeInfo(collegeinfo.getId(),collegeinfo.getCollegeName());
    }

    public CollegeInfo updateByCollegeId(CollegeInfo college) {
        CollegeInfo info = null;
        Optional<CollegeInfo> optionall = repo.findById(college.getId());
        if(optionall.isPresent()){
            info = optionall.get();
            info.setCollegeName(college.getCollegeName());
            repo.save(info);
        }
        else{
            return new CollegeInfo(college.getId(),college.getCollegeName());
        }
        return info;
    }
    public String deleteCollegeById(int id) {
        repo.deleteById(id);
        return "college deleted...";
    }

    public Departments addDepts(Departments dept) {
        return deptrepo.save(dept);
    }

    public CollegeInfo addDeptByid(int id) {
        Departments dept = deptrepo.findByid(id);
        CollegeInfo clg = repo.findById(id).orElse(null);
        clg.getDepartment().add(dept);
        return repo.save(clg);
    }


}
