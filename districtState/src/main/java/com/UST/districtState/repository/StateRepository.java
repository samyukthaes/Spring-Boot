package com.UST.districtState.repository;

import com.UST.districtState.entity.districtstate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<districtstate,String> {


    List<districtstate> findByState(String state);
}
