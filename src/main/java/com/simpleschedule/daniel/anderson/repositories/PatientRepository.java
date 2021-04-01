package com.simpleschedule.daniel.anderson.repositories;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;

import com.simpleschedule.daniel.anderson.entities.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer>{
	
	//CUSTOM FINDER METHODS FOR ATTRIBUTES
	public Patient findByPLastName(String pLastName);
	
	public Patient findByPLastNameAndPFirstName(String pLastName, String pFirstName);
	
	public Patient findByPLastNameAndPFirstNameAndPDob(
			String pLastName, String pFirstnName, Date pDob);
	
	public Patient findByPLastNameAndPFirstNameAndPPrimary(
			String pLastName, String pFirstName, Integer pPrimary);
	
	public Patient findByPFirstNameAndPLastNameAndPDobAndPPrimaryId(
			String pFirstName, String pLastName, Date pDob, Integer pPrimaryId);
	
	public Patient findByPFirstName(String pFirstName);
	
	public Patient findByPDob(Date pDob);
	
	public Patient findByPPrimary(Integer pPrimary);
	
}
