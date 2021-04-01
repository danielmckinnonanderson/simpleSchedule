package com.simpleschedule.daniel.anderson.repositories;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;

import com.simpleschedule.daniel.anderson.entities.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer>{
	
	//CUSTOM FINDER METHODS FOR ATTRIBUTES
	//ALL POSSIBLE PERMUTATIONS
	
	Patient findByPFirstName(String pFirstName);
	Patient findByPFirstNameAndPLastName(String pFirstName, String pLastName);
	Patient findByPFirstNameAndPDob(String pFirstName, Date pDob);
	Patient findByPFirstNameAndPPrimary(String pFirstName, Integer pPrimary);
	
	Patient findByPFirstNameAndPLastNameAndPDob(String pFirstName, String pLastName, Date pDob);
	Patient findByPFirstNameAndPLastNameAndPPrimary(
			String pFirstName, String pLastName, Integer pPrimary);
	Patient findByPFirstNameAndPDobAndPPrimary(String pFirstName, Date pDob, Integer pPrimary);
		
	
	Patient findByPLastName(String pLastName);
	Patient findByPLastNameAndPDob(String pLastName, Date pDob);
	Patient findByPLastNameAndPPrimary(String pLastName, Integer pPrimary);
	
	Patient findByPLastNameAndPDobAndPPrimary(String pLastName, Date pDob, Integer pPrimary);
	

	Patient findByPDob(Date pDob);
	Patient findByPDobAndPPrimary(Date pDob, Integer pPrimary);
	
	Patient findByPPrimary(Integer pPrimary);
	
	Patient findByPFirstNameAndPLastNameAndPDobAndPPrimaryId(
			String pFirstName, String pLastName, Date pDob, Integer pPrimaryId);	
}
