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
		if (iPatientId != null) {
			Insurance foundInsurance = insuranceRepository.findByiPatientId(iPatientId);
			if (foundInsurance != null) {
				return foundInsurance;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	//SAVE NEW INSURANCE
	public Insurance saveNewInsurance(Insurance insurance) {
		if (insurance != null) {
			if (insuranceRepository.findByiPatientId(insurance.getiPatientId()) == null) {
				return insuranceRepository.save(insurance);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	//UPDATE INSURANCE
	public Insurance updateInsurance(Insurance updateInsurance) {
		if (updateInsurance != null) {
			if (insuranceRepository.findByiPatientId(updateInsurance.getiPatientId()) != null) {
				return insuranceRepository.save(updateInsurance);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	//DELETE INSURANCE
	public boolean deleteInsurance(Insurance deleteInsurance) {
		if (deleteInsurance != null) {
			if (insuranceRepository.findByiPatientId(deleteInsurance.getiPatientId()) != null) {
				insuranceRepository.delete(deleteInsurance);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}