package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {
    public List<Whisky> getAllWhiskiesFromYear(int year);
    public List<Whisky> getAllWhiskiesFromRegion(String region);
    public List<Whisky> getAllWhiskiesFromDistilleryOfAge(Long distilleryId, int age);
}
