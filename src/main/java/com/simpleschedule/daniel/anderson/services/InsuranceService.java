package com.simpleschedule.daniel.anderson.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleschedule.daniel.anderson.entities.Insurance;
import com.simpleschedule.daniel.anderson.repositories.InsuranceRepository;

@Service
public class InsuranceService {
	private InsuranceRepository insuranceRepository;
	
	@Autowired
	public InsuranceService(InsuranceRepository insuranceRepository) {
		this.insuranceRepository = insuranceRepository;
	}
	
	//SAVE NEW INSURANCE
	public Insurance saveNewInsurance(Insurance insurance) {
		return insuranceRepository.save(insurance);
	}
}