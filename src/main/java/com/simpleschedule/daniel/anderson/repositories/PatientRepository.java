package com.simpleschedule.daniel.anderson.repositories;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;

import com.simpleschedule.daniel.anderson.entities.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer>{
	
	//CUSTOM FINDER METHODS FOR ATTRIBUTES
	//ALL POSSIBLE PERMUTATIONS
	
	public Patient findByPFirstName(String pFirstName);
	public Patient findByPFirstNameAndPLastName(String pFirstName, String pLastName);
	public Patient findByPFirstNameAndPDob(String pFirstName, Date pDob);
	public Patient findByPFirstNameAndPPrimary(String pFirstName, Integer pPrimary);
	
	public Patient findByPFirstNameAndPLastNameAndPDob(String pFirstName, String pLastName, Date pDob);
	public Patient findByPFirstNameAndPLastNameAndPPrimary(
			String pFirstName, String pLastName, Integer pPrimary);
	public Patient findByPFirstNameAndPDobAndPPrimary(String pFirstName, Date pDob, Integer pPrimary);
		
	
	public Patient findByPLastName(String pLastName);
	public Patient findByPLastNameAndPDob(String pLastName, Date pDob);
	public Patient findByPLastNameAndPPrimary(String pLastName, Integer pPrimary);
	
	public Patient findByPLastNameAndPDobAndPPrimary(String pLastName, Date pDob, Integer pPrimary);
	

	public Patient findByPDob(Date pDob);
	public Patient findByPDobAndPPrimary(Date pDob, Integer pPrimary);
	
	public Patient findByPPrimary(Integer pPrimary);
	
	public Patient findByPFirstNameAndPLastNameAndPDobAndPPrimaryId(
			String pFirstName, String pLastName, Date pDob, Integer pPrimaryId);	
}
