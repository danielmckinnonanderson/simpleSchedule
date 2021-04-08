package com.simpleschedule.daniel.anderson.services;

import java.util.Date;
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
	
	//SINGLE FINDER METHOD FOR ID
	public Patient findByPId(Integer pId) {
		return patientRepository.findByPId(pId);
	}
	
	//SAVE NEW PATIENT
	public Patient saveNewPatient(Patient patient) {
		return patientRepository.save(patient);
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
			Patient patient) {
		//setup null values from blank fields
		if (patient.getpFirstName() == "") {
			patient.setpFirstName(null);
		}
		if (patient.getpLastName() == "") {
			patient.setpLastName(null);
		}
		
		//parse fields for null values and call appropriate query method
		if (patient.getpFirstName() != null && patient.getpLastName() != null && patient.getpDob() != null && patient.getpPrimary() != null) {
			return findByPFirstNameAndPLastNameAndPDobAndPPrimary(
					patient.getpFirstName(), patient.getpLastName(), patient.getpDob(), patient.getpPrimary());
		} else if (patient.getpLastName() != null && patient.getpDob() != null && patient.getpPrimary() != null) {
			return findByPLastNameAndPDobAndPPrimary(
					patient.getpLastName(), patient.getpDob(), patient.getpPrimary());
		} else if (patient.getpFirstName() != null && patient.getpDob() != null && patient.getpPrimary() != null) {
			return findByPFirstNameAndPDobAndPPrimary(
					patient.getpFirstName(), patient.getpDob(), patient.getpPrimary());
		} else if (patient.getpFirstName() != null && patient.getpLastName() != null && patient.getpPrimary() != null) {
			return findByPFirstNameAndPLastNameAndPPrimary(
					patient.getpFirstName(), patient.getpLastName(), patient.getpPrimary());
		} else if (patient.getpFirstName() != null && patient.getpLastName() != null && patient.getpDob() != null) {
			return findByPFirstNameAndPLastNameAndPDob(
					patient.getpFirstName(), patient.getpLastName(), patient.getpDob());
		} else if (patient.getpFirstName() != null && patient.getpLastName() != null) {
			return findByPFirstNameAndPLastName(patient.getpFirstName(), patient.getpLastName());
		} else if (patient.getpFirstName() != null && patient.getpDob() != null) {
			return findByPFirstNameAndPDob(patient.getpFirstName(), patient.getpDob());
		} else if (patient.getpFirstName() != null && patient.getpPrimary() != null) {
			return findByPFirstNameAndPPrimary(patient.getpFirstName(), patient.getpPrimary());
		} else if (patient.getpLastName() != null && patient.getpDob() != null) {
			return findByPLastNameAndPDob(patient.getpLastName(), patient.getpDob());
		} else if (patient.getpLastName() != null && patient.getpPrimary() != null) {
			return findByPLastNameAndPPrimary(patient.getpLastName(), patient.getpPrimary());
		} else if (patient.getpDob() != null && patient.getpPrimary() != null) {
			return findByPDobAndPPrimary(patient.getpDob(), patient.getpPrimary());
		} else if (patient.getpFirstName() != null) {
			return findByPFirstName(patient.getpFirstName());
		} else if (patient.getpLastName() != null) {
			return findByPLastName(patient.getpLastName());
		} else if (patient.getpDob() != null) {
			return findByPDob(patient.getpDob());
		} else if (patient.getpPrimary() != null) {
			return findByPPrimary(patient.getpPrimary());
		} else {
			System.out.println("No Fields Provided");
			return null;
		}
	}
	
	//UPDATE PATIENT FROM FIELDS
	public Patient updatePatient(Patient oldPatient, Patient updatePatient) {
		//check for null field values and if oldPatient's value is also not null, set updatePatient's value equal to oldPatient's
		if (updatePatient.getpFirstName() == null && oldPatient.getpFirstName() != null) {
			updatePatient.setpFirstName(oldPatient.getpFirstName());
			System.out.println("New FirstName: " + updatePatient.getpFirstName());
		}
		if (updatePatient.getpLastName() == null && oldPatient.getpLastName() != null) {
			updatePatient.setpLastName(oldPatient.getpLastName());
			System.out.println("New LastName: " + updatePatient.getpLastName());
		}
		if (updatePatient.getpDob() == null && oldPatient.getpDob() != null) {
			updatePatient.setpDob(oldPatient.getpDob());
			System.out.println("New Dob: " + updatePatient.getpDob());
		}
		if (updatePatient.getpPrimary() == null && oldPatient.getpPrimary() != null) {
			updatePatient.setpPrimary(oldPatient.getpPrimary());
			System.out.println("New Primary: " + updatePatient.getpPrimary());
		}
		//merge updated patient to the database
		System.out.println(updatePatient);
		return patientRepository.save(updatePatient);
	}
	
	
}
