package com.simpleschedule.daniel.anderson.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleschedule.daniel.anderson.entities.Location;
import com.simpleschedule.daniel.anderson.repositories.LocationRepository;

@Service
public class LocationService {
	private LocationRepository locationRepository;
	
	@Autowired
	public LocationService(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}
	
	public HashMap<Integer, Location> getAll() {
		HashMap<Integer, Location> locationMap = new HashMap<Integer, Location>();
		for (Location location : locationRepository.findAll()) {
			locationMap.put(location.getlId(), location);
		}
		return locationMap;
	}
}
