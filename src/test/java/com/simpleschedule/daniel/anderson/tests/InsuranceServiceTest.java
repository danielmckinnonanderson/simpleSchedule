package com.simpleschedule.daniel.anderson.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.simpleschedule.daniel.anderson.entities.Insurance;
import com.simpleschedule.daniel.anderson.repositories.InsuranceRepository;
import com.simpleschedule.daniel.anderson.services.InsuranceService;

class InsuranceServiceTest {
	private static InsuranceRepository insuranceRepository;
	private static InsuranceService insuranceService;
	
	@BeforeAll
	static void setup() {
		insuranceRepository = Mockito.mock(InsuranceRepository.class);
		insuranceService = new InsuranceService(insuranceRepository);
	}
	
	@Test
	void testFindByIPatientId() {
		Insurance testInsurance = new Insurance(1, "MMN999888777", "AAAABBBB", "CCCCDDDD", "TestProvider");
		
		Mockito.when(insuranceRepository.findByiPatientId(testInsurance.getiPatientId())).thenReturn(testInsurance);
		
		Insurance actual = insuranceService.findByiPatientId(1);
		Insurance expected = new Insurance(1, "MMN999888777", "AAAABBBB", "CCCCDDDD", "TestProvider");
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testSaveNewInsurance() {
		Insurance testInsurance = new Insurance(1, "MMN999888777", "AAAABBBB", "CCCCDDDD", "TestProvider");
		
		Mockito.when(insuranceRepository.findByiPatientId(testInsurance.getiPatientId())).thenReturn(null);
		Mockito.when(insuranceRepository.save(testInsurance)).thenReturn(testInsurance);
		
		Insurance actual = insuranceService.saveNewInsurance(testInsurance);
		Insurance expected = new Insurance(1, "MMN999888777", "AAAABBBB", "CCCCDDDD", "TestProvider");
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testUpdateInsurance() {
		Insurance oldInsurance = new Insurance(1, "MMN999888777", "AAAABBBB", "CCCCDDDD", "TestProvider");
		Insurance updateInsurance = new Insurance(1, "MMN999888666", "AAAABBDD", "CCCCDDEE", "TestProvider2");
		
		Mockito.when(insuranceRepository.findByiPatientId(updateInsurance.getiPatientId())).thenReturn(oldInsurance);
		Mockito.when(insuranceRepository.save(updateInsurance)).thenReturn(updateInsurance);
		
		Insurance actual = insuranceService.updateInsurance(updateInsurance);
		Insurance expected = new Insurance(1, "MMN999888666", "AAAABBDD", "CCCCDDEE", "TestProvider2");
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testDeleteInsurance() {
		Insurance testInsurance = new Insurance(1, "MMN999888777", "AAAABBBB", "CCCCDDDD", "TestProvider");
		
		Mockito.when(insuranceRepository.findByiPatientId(testInsurance.getiPatientId())).thenReturn(testInsurance);
		Mockito.doNothing().when(insuranceRepository).delete(testInsurance);
		
		boolean actual = insuranceService.deleteInsurance(testInsurance);
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
}
