package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistilleryRepositoryCustom {
    public List<Distillery> getAllDistilleriesFromRegion(String region);
}
