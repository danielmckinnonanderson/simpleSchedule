package com.simpleschedule.daniel.anderson.services;

import java.sql.Date;

import com.simpleschedule.daniel.anderson.entities.Patient;
import com.simpleschedule.daniel.anderson.repositories.PatientRepository;

public class PatientService {
	private PatientRepository patientRepository;
	
	public PatientService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	//CUSTOM FINDER METHODS FOR ATTRIBUTES
	public Patient findByPFirstName(String pFirstName) {
		return patientRepository.findByPFirstName(pFirstName);
	}
	public Patient findByPFirstNameAndPLastName(String pFirstName, String pLastName) {
		return patientRepository.findByPFirstNameAndPLastName(pFirstName, pLastName);
	}
	public Patient findByPFirstNameAndPDob(String pFirstName, Date pDob) {
		return patientRepository.findByPFirstNameAndPDob(pFirstName, pDob);
	}
	public Patient findByPFirstNameAndPPrimary(String pFirstName, Integer pPrimary) {
		return patientRepository.findByPFirstNameAndPPrimary(pFirstName, pPrimary);
	}
	public Patient findByPFirstNameAndPLastNameAndPDob(
			String pFirstName, String pLastName, Date pDob) {
		return patientRepository.findByPFirstNameAndPLastNameAndPDob(
				pFirstName, pLastName, pDob);
	}
	public Patient findByPFirstNameAndPLastNameAndPPrimary(
			String pFirstName, String pLastName, Integer pPrimary) {
		return patientRepository.findByPFirstNameAndPLastNameAndPPrimary(
				pFirstName, pLastName, pPrimary);
	}
	public Patient findByPFirstNameAndPDobAndPPrimary(
			String pFirstName, Date pDob, Integer pPrimary) {
		return patientRepository.findByPFirstNameAndPDobAndPPrimary(
				pFirstName, pDob, pPrimary);
	}
	public Patient findByPLastName(String pLastName) {
		return patientRepository.findByPLastName(pLastName);
	}
	public Patient findByPLastNameAndPDob(String pLastName, Date pDob) {
		return patientRepository.findByPLastNameAndPDob(pLastName, pDob);
	}
	public Patient findByPLastNameAndPPrimary(String pLastName, Integer pPrimary) {
		return patientRepository.findByPLastNameAndPPrimary(pLastName, pPrimary);
	}
	public Patient findByPLastNameAndPDobAndPPrimary(
			String pLastName, Date pDob, Integer pPrimary) {
		return patientRepository.findByPLastNameAndPDobAndPPrimary(
				pLastName, pDob, pPrimary);
	}
	public Patient findByPDob(Date pDob) {
		return patientRepository.findByPDob(pDob);
	}
	public Patient findByPDobAndPPrimary(Date pDob, Integer pPrimary) {
		return patientRepository.findByPDobAndPPrimary(pDob, pPrimary);
	}
	public Patient findByPPrimary(Integer pPrimary) {
		return patientRepository.findByPPrimary(pPrimary);
	}
	public Patient findByPFirstNameAndPLastNameAndPDobAndPPrimaryId(
			String pFirstName, String pLastName, Date pDob, Integer pPrimaryId) {
		return patientRepository.findByPFirstNameAndPLastNameAndPDobAndPPrimaryId(
				pFirstName, pLastName, pDob, pPrimaryId);
	}
}
