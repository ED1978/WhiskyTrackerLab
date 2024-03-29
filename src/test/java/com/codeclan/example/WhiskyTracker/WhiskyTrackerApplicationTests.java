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

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void findAllWhiskiesByYear() {
		List<Whisky> found = whiskyRepository.findAllWhiskiesByYear(2018);
		assertEquals("The Glendronach Revival", found.get(0).getName());
	}

	@Test
	public void findAllDistilleriesFromRegion() {
		List<Distillery> found = distilleryRepository.findAllDistilleriesFromRegion("Speyside");
		assertEquals(2, found.size());
	}

	@Test
	public void findAllWhiskiesByDistilleryIdAndYear() {
		List<Whisky> found = whiskyRepository.findAllWhiskiesByDistilleryNameAndAge("Glendronach", 15);
		assertEquals("The Glendronach Revival", found.get(0).getName());
	}
}
