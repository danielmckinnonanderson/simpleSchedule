package com.simpleschedule.daniel.anderson.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleschedule.daniel.anderson.entities.Patient;
import com.simpleschedule.daniel.anderson.repositories.PatientRepository;

@Service
public class PatientService {
	private PatientRepository patientRepository;
	
	@Autowired
	public PatientService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	//CUSTOM FINDER METHODS FOR ATTRIBUTES
	private List<Patient> findByPFirstName(String pFirstName) {
		return patientRepository.findByPFirstName(pFirstName);
	}
	private List<Patient> findByPFirstNameAndPLastName(String pFirstName, String pLastName) {
		return patientRepository.findByPFirstNameAndPLastName(pFirstName, pLastName);
	}
	private List<Patient> findByPFirstNameAndPDob(String pFirstName, Date pDob) {
		return patientRepository.findByPFirstNameAndPDob(pFirstName, pDob);
	}
	private List<Patient> findByPFirstNameAndPPrimary(String pFirstName, Integer pPrimary) {
		return patientRepository.findByPFirstNameAndPPrimary(pFirstName, pPrimary);
	}
	private List<Patient> findByPFirstNameAndPLastNameAndPDob(
			String pFirstName, String pLastName, Date pDob) {
		return patientRepository.findByPFirstNameAndPLastNameAndPDob(
				pFirstName, pLastName, pDob);
	}
	private List<Patient> findByPFirstNameAndPLastNameAndPPrimary(
			String pFirstName, String pLastName, Integer pPrimary) {
		return patientRepository.findByPFirstNameAndPLastNameAndPPrimary(
				pFirstName, pLastName, pPrimary);
	}
	private List<Patient> findByPFirstNameAndPDobAndPPrimary(
			String pFirstName, Date pDob, Integer pPrimary) {
		return patientRepository.findByPFirstNameAndPDobAndPPrimary(
				pFirstName, pDob, pPrimary);
	}
	private List<Patient> findByPLastName(String pLastName) {
		return patientRepository.findByPLastName(pLastName);
	}
	private List<Patient> findByPLastNameAndPDob(String pLastName, Date pDob) {
		return patientRepository.findByPLastNameAndPDob(pLastName, pDob);
	}
	private List<Patient> findByPLastNameAndPPrimary(String pLastName, Integer pPrimary) {
		return patientRepository.findByPLastNameAndPPrimary(pLastName, pPrimary);
	}
	private List<Patient> findByPLastNameAndPDobAndPPrimary(
			String pLastName, Date pDob, Integer pPrimary) {
		return patientRepository.findByPLastNameAndPDobAndPPrimary(
				pLastName, pDob, pPrimary);
	}
	private List<Patient> findByPDob(Date pDob) {
		return patientRepository.findByPDob(pDob);
	}
	private List<Patient> findByPDobAndPPrimary(Date pDob, Integer pPrimary) {
		return patientRepository.findByPDobAndPPrimary(pDob, pPrimary);
	}
	private List<Patient> findByPPrimary(Integer pPrimary) {
		return patientRepository.findByPPrimary(pPrimary);
	}
	private List<Patient> findByPFirstNameAndPLastNameAndPDobAndPPrimary(
			String pFirstName, String pLastName, Date pDob, Integer pPrimary) {
		return patientRepository.findByPFirstNameAndPLastNameAndPDobAndPPrimary(
				pFirstName, pLastName, pDob, pPrimary);
	}
	
	//HIGHER-LEVEL...DISCERNING USER INPUT AND ROUTING TO APPROPRIATE QUERY METHOD
	public List<Patient> findPatientUsingFields(
			String pFirstName, String pLastName, Date pDob, Integer pPrimary) {
		if (pFirstName != null && pLastName != null && pDob != null && pPrimary != null) {
			return findByPFirstNameAndPLastNameAndPDobAndPPrimary(
					pFirstName, pLastName, pDob, pPrimary);
		} else if (pLastName != null && pDob != null && pPrimary != null) {
			return findByPLastNameAndPDobAndPPrimary(
					pLastName, pDob, pPrimary);
		} else if (pFirstName != null && pDob != null && pPrimary != null) {
			return findByPFirstNameAndPDobAndPPrimary(
					pFirstName, pDob, pPrimary);
		} else if (pFirstName != null && pLastName != null && pPrimary != null) {
			return findByPFirstNameAndPLastNameAndPPrimary(
					pFirstName, pLastName, pPrimary);
		} else if (pFirstName != null && pLastName != null && pDob != null) {
			return findByPFirstNameAndPLastNameAndPDob(
					pFirstName, pLastName, pDob);
		} else if (pFirstName != null && pLastName != null) {
			return findByPFirstNameAndPLastName(pFirstName, pLastName);
		} else if (pFirstName != null && pDob != null) {
			return findByPFirstNameAndPDob(pFirstName, pDob);
		} else if (pFirstName != null && pPrimary != null) {
			return findByPFirstNameAndPPrimary(pFirstName, pPrimary);
		} else if (pLastName != null && pDob != null) {
			return findByPLastNameAndPDob(pLastName, pDob);
		} else if (pLastName != null && pPrimary != null) {
			return findByPLastNameAndPPrimary(pLastName, pPrimary);
		} else if (pDob != null && pPrimary != null) {
			return findByPDobAndPPrimary(pDob, pPrimary);
		} else if (pFirstName != null) {
			return findByPFirstName(pFirstName);
		} else if (pLastName != null) {
			return findByPLastName(pLastName);
		} else if (pDob != null) {
			return findByPDob(pDob);
		} else if (pPrimary != null) {
			return findByPPrimary(pPrimary);
		} else {
			return null;
		}
	}
}
