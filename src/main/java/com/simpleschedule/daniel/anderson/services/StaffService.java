package com.simpleschedule.daniel.anderson.services;

import java.util.List;

import com.simpleschedule.daniel.anderson.entities.Staff;
import com.simpleschedule.daniel.anderson.repositories.StaffRepository;

public class StaffService {
	private StaffRepository staffRepository;
	
	public List<Staff> findAllDoctors(String sTitle) {
		return staffRepository.findByTitle("Doctor");
	}
}