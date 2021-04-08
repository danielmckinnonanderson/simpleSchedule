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
	
	//FIND BY iPatientId
	public Insurance findByiPatientId(Integer iPatientId) {
		return insuranceRepository.findByiPatientId(iPatientId);
	}
	
	//SAVE NEW INSURANCE
	public Insurance saveNewInsurance(Insurance insurance) {
		return insuranceRepository.save(insurance);
	}
	
	//UPDATE INSURANCE
	public Insurance updateInsurance(Insurance updateInsurance) {
		return insuranceRepository.save(updateInsurance);
	}
	
	//DELETE INSURANCE
	public void deleteInsurance(Insurance deleteInsurance) {
		insuranceRepository.delete(deleteInsurance);
		System.out.println("REMOVED: " + deleteInsurance);
	}
}