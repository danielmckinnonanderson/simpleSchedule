package com.simpleschedule.daniel.anderson.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.simpleschedule.daniel.anderson.entities.Staff;
import com.simpleschedule.daniel.anderson.repositories.StaffRepository;
import com.simpleschedule.daniel.anderson.services.StaffService;

class StaffServiceTest {
	private static StaffRepository staffRepository;
	private static StaffService staffService;
	
	@BeforeAll
	static void setup() {
		staffRepository = Mockito.mock(StaffRepository.class);
		staffService = new StaffService(staffRepository);
	}
	
	@Test
	void testFindAllDoctors() {
		List<Staff> doctorList = new ArrayList<>();
		
		doctorList.add(new Staff(1, "Test", "Staff", 1, "Doctor"));
		doctorList.add(new Staff(2, "Test", "Staff", 1, "Doctor"));
		
		Mockito.when(staffRepository.findBySTitle("Doctor")).thenReturn(doctorList);
		List<Staff> actual = staffService.findAllDoctors();
		
		int expected = 2;
		
		assertEquals(expected, actual.size());
	}
}
