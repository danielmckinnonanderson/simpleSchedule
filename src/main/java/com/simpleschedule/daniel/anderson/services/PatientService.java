package com.simpleschedule.daniel.anderson.services;

import java.sql.Date;

import com.simpleschedule.daniel.anderson.entities.Patient;
import com.simpleschedule.daniel.anderson.repositories.PatientRepository;

public class PatientService {
	private PatientRepository patientRepository;
	
	//CUSTOM FINDER METHODS FOR ATTRIBUTES
	public PatientService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	public Patient findByPLastName(String pLastName) {
		return patientRepository.findByPLastName(pLastName);
	}
	
	public Patient findPatientByPFirstName(String pFirstName) {
		return patientRepository.findByPFirstName(pFirstName);
	}
	
	public Patient findByPDob(Date pDob) {
		return patientRepository.findByPDob(pDob);
	}
	
	public Patient findByPrimary(Integer pPrimary) {
		return patientRepository.findByPPrimary(pPrimary);
	}
	
	public Patient findPatientByPFirstNameAndPLastNameAndPDobAndPPrimaryId(
			String pFirstName, String pLastName, Date pDob, Integer pPrimaryId) {
		return patientRepository.findByPFirstNameAndPLastNameAndPDobAndPPrimaryId(
				pFirstName, pLastName, pDob, pPrimaryId);
	}
	
	
}
