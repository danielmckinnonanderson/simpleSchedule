package com.simpleschedule.daniel.anderson.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.simpleschedule.daniel.anderson.entities.Location;
import com.simpleschedule.daniel.anderson.repositories.LocationRepository;
import com.simpleschedule.daniel.anderson.services.LocationService;

class LocationServiceTest {
	private static LocationRepository locationRepository;
	private static LocationService locationService;
	
	@BeforeAll
	static void setup() {
		locationRepository = Mockito.mock(LocationRepository.class);
		locationService = new LocationService(locationRepository);
	}
	
	@Test 
	void testGetAll() {
		List<Location> locationList = new ArrayList<>();
		
		locationList.add(new Location(1, "testCity1", "TS"));
		locationList.add(new Location(2, "testCity2", "TS"));
		
		Mockito.when(locationRepository.findAll()).thenReturn(locationList);
		
		HashMap<Integer, Location> actual = locationService.getAll();
		
		int expected = 2;
		
		assertEquals(expected, actual.size());
	}
}
