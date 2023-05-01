package com.UST.districtState.controller;

import com.UST.districtState.entity.districtstate;
import com.UST.districtState.service.StateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StateController {
    @Autowired
    public StateService stateService;


    @GetMapping("/{State}")
    public List<districtstate> getDistrictsByState(@PathVariable String State) {
        return stateService.getAllDistrictsByState(State);
    }




}
