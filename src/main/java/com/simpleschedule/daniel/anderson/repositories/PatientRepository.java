package com.simpleschedule.daniel.anderson.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.simpleschedule.daniel.anderson.entities.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer>{
	
	//CUSTOM FINDER METHODS FOR ATTRIBUTES
	//ALL POSSIBLE PERMUTATIONS
	
	List<Patient> findByPFirstName(String pFirstName);
	List<Patient> findByPFirstNameAndPLastName(String pFirstName, String pLastName);
	List<Patient> findByPFirstNameAndPDob(String pFirstName, Date pDob);
	List<Patient> findByPFirstNameAndPPrimary(String pFirstName, Integer pPrimary);
	
	List<Patient> findByPFirstNameAndPLastNameAndPDob(String pFirstName, String pLastName, Date pDob);
	List<Patient> findByPFirstNameAndPLastNameAndPPrimary(
			String pFirstName, String pLastName, Integer pPrimary);
	List<Patient> findByPFirstNameAndPDobAndPPrimary(String pFirstName, Date pDob, Integer pPrimary);
		
	
	List<Patient> findByPLastName(String pLastName);
	List<Patient> findByPLastNameAndPDob(String pLastName, Date pDob);
	List<Patient> findByPLastNameAndPPrimary(String pLastName, Integer pPrimary);
	
	List<Patient> findByPLastNameAndPDobAndPPrimary(String pLastName, Date pDob, Integer pPrimary);
	

	List<Patient> findByPDob(Date pDob);
	List<Patient> findByPDobAndPPrimary(Date pDob, Integer pPrimary);
	
	List<Patient> findByPPrimary(Integer pPrimary);
	
	List<Patient> findByPFirstNameAndPLastNameAndPDobAndPPrimary(
			String pFirstName, String pLastName, Date pDob, Integer pPrimary);	

}
