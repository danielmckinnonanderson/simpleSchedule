package com.simpleschedule.daniel.anderson.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleschedule.daniel.anderson.entities.Staff;
import com.simpleschedule.daniel.anderson.repositories.StaffRepository;

@Service
public class StaffService {
	private StaffRepository staffRepository;
	
	@Autowired
	public StaffService(StaffRepository staffRepository) {
		this.staffRepository = staffRepository;
	}
	
	public List<Staff> findAllDoctors() {
		return staffRepository.findBySTitle("Doctor");
	}
}