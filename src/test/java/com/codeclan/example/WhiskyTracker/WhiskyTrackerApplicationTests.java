package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	DistilleryRepository distilleryRepository;

	@Autowired
	WhiskyRepository whiskyRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetAllDistilleriesFromRegion(){
		List<Distillery> results = distilleryRepository.getAllDistilleriesFromRegion("Highland");
	}

	@Test
	public void canGetAllWhiskiesFromYear(){
		List<Whisky> results = whiskyRepository.getAllWhiskiesFromYear(2018);
	}

	@Test
	public void canGetAllWhiskiesFromRegion(){
		List<Whisky> results = whiskyRepository.getAllWhiskiesFromRegion("Highland");
	}

	@Test
	public void canGetAllWhiskiesFromDistilleryOfAge(){
		List<Whisky> results = whiskyRepository.getAllWhiskiesFromDistilleryOfAge(1L, 12);
	}

	@Test
	public void canGetAllDistilleriesWithWhiskiesAgedTwelve(){
		List<Distillery> results = distilleryRepository.getAllDistilleriesWithWhiskiesAgedTwelve();
	}
}
