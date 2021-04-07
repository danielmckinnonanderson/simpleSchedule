package com.simpleschedule.daniel.anderson.services;

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
	
	public Iterable<Location> getAll() {
		return locationRepository.findAll();
	}
}
