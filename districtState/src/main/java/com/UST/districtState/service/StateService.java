package com.UST.districtState.service;

import com.UST.districtState.entity.districtstate;
import com.UST.districtState.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class StateService {
    @Autowired
    public StateRepository repo;


    public List<districtstate> getAllDistrictsByState(String state) {
        return repo.findByState(state);
    }
}
