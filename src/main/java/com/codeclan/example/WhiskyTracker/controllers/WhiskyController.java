package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @Autowired
    DistilleryRepository distilleryRepository;

    //TODO: route for all the whiskies for a particular year
    @GetMapping(value = "{year}")
    public List<Whisky> getAllWhiskiesFromYear(@PathVariable int year){
        return whiskyRepository.getAllWhiskiesFromYear(year);

    }

    //TODO: route for all the whisky from a particular region
    @GetMapping(value = "region/{region}")
    public List<Whisky> getAllWhiskiesFromRegion(@PathVariable String region) {
        return whiskyRepository.getAllWhiskiesFromRegion(region);
    }

    @GetMapping(value = "distillery/{id}/age/{age}")
    public List<Whisky> getAllWhiskiesFromDistilleryOfAge(@PathVariable Long id, @PathVariable int age) {
        return whiskyRepository.getAllWhiskiesFromDistilleryOfAge(id, age);
    }



}
