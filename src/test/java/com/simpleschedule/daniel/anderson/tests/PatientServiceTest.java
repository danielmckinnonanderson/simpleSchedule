package com.simpleschedule.daniel.anderson.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.simpleschedule.daniel.anderson.entities.Patient;
import com.simpleschedule.daniel.anderson.repositories.PatientRepository;
import com.simpleschedule.daniel.anderson.services.PatientService;

class PatientServiceTest {
	private static PatientRepository patientRepository;
	private static PatientService patientService;
	
	@BeforeAll
	static void setup() {
		patientRepository = Mockito.mock(PatientRepository.class);
		patientService = new PatientService(patientRepository);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testFindByPId() {
		Patient testPatient = new Patient(1, "Test", "Patient", new Date(2021, 0, 1), 1);
		
		Mockito.when(patientRepository.findByPId(testPatient.getpId())).thenReturn(testPatient);
		
		Patient actual = patientService.findByPId(1);
		Patient expected = new Patient(1, "Test", "Patient", new Date(2021, 0, 1), 1);
		
		assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testSaveNewPatient() {
		Patient testPatient = new Patient(1, "Test", "Patient", new Date(2021, 0, 1), 1);
		
		Mockito.when(patientRepository.findByPId(testPatient.getpId())).thenReturn(null);
		Mockito.when(patientRepository.save(testPatient)).thenReturn(testPatient);
		
		Patient actual = patientService.saveNewPatient(testPatient);
		Patient expected = new Patient(1, "Test", "Patient", new Date(2021, 0, 1), 1);
		
		assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	void testDeletePatient() {
		Patient testPatient = new Patient(1, "Test", "Patient", new Date(2021, 0, 1), 1);
		
		Mockito.when(patientRepository.findByPId(testPatient.getpId())).thenReturn(testPatient);
		Mockito.doNothing().when(patientRepository).delete(testPatient);
		
		boolean actual = patientService.deletePatient(testPatient);
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	void testFindPatientUsingFields() {
		Patient searchPatient = new Patient(null, null, "Patient", null, null);
		Patient testPatient = new Patient(1, "Test", "Patient", new Date(2021, 0, 1), 1);
		List<Patient> patientList = new ArrayList<>();
		patientList.add(testPatient);
		
		Mockito.when(patientRepository.findByPLastName(searchPatient.getpLastName())).thenReturn(patientList);
		
		List<Patient> actual = patientService.findPatientUsingFields(searchPatient);
		int expected = 1;
		
		assertEquals(expected, actual.size());
	}
	
	@SuppressWarnings("deprecation")
	void testUpdatePatient() {
		Patient oldPatient = new Patient(1, "Test", "Patient", new Date(2021, 0, 1), 1);
		Patient updatePatient = new Patient(1, "Updated", "Now", new Date(2021, 0, 1), 3);
		
		Mockito.when(patientRepository.save(updatePatient)).thenReturn(updatePatient);
		
		Patient actual = patientService.updatePatient(oldPatient, updatePatient);
		Patient expected = new Patient(1, "Updated", "Now", new Date(2021, 0, 1), 3);
		
		assertEquals(expected, actual);
	}
}
