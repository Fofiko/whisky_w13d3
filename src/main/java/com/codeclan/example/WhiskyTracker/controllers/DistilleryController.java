package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/distilleries")
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    //TODO: route for all the distilleries for a particular region
    @GetMapping(value = "{region}")
    public List<Distillery> getAllDistilleriesFromRegion(@PathVariable String region){
        return distilleryRepository.getAllDistilleriesFromRegion(region);

    }

    @GetMapping(value = "age/{age}")
    public List<Distillery> getAllDistilleriesWithWhiskiesAgedTwelve(@PathVariable int age){
        return distilleryRepository.getAllDistilleriesWithWhiskiesAgedTwelve();
    }


}
