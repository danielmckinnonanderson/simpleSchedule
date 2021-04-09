package com.simpleschedule.daniel.anderson.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.simpleschedule.daniel.anderson.entities.Appointment;
import com.simpleschedule.daniel.anderson.repositories.AppointmentRepository;
import com.simpleschedule.daniel.anderson.services.AppointmentService;

class AppointmentServiceTest {
	private static AppointmentRepository appointmentRepository;
	private static AppointmentService appointmentService;
	
	@BeforeAll
	static void setup() {
		appointmentRepository = Mockito.mock(AppointmentRepository.class);
		appointmentService = new AppointmentService(appointmentRepository);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testFindByAId() {
		Appointment testAppointment = new Appointment(1, new Date(2021, 0, 1), 1, 1, 1, new Date(1970, 0, 1, 8, 0),new Date(1970, 0, 1, 9, 0));
		
		Mockito.when(appointmentRepository.findByAId(1)).thenReturn(testAppointment);
		
		Appointment actual = appointmentService.findByAId(1);
		Appointment expected = testAppointment;
		
		assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testFindByAPatientId() {
		List<Appointment> appointmentList = new ArrayList<>();
		
		appointmentList.add(new Appointment(1, new Date(2021, 0, 1), 1, 1, 1, new Date(1970, 0, 1, 8, 0), new Date(1970, 0, 1, 9, 0)));
		appointmentList.add(new Appointment(2, new Date(2021, 0, 1), 1, 1, 2, new Date(1970, 0, 1, 10, 30), new Date(1970, 0, 1, 11, 30)));
		
		Mockito.when(appointmentRepository.findByAPatientId(1)).thenReturn(appointmentList);
		
		Map<Integer, Appointment> actual = appointmentService.findByAPatientId(1);
		
		int expected = 2;
		
		assertEquals(expected, actual.size());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testSaveAppointment() {
		Appointment testAppointment = new Appointment(1, new Date(2021, 0, 1), 1, 1, 1, new Date(1970, 0, 1, 8, 0),new Date(1970, 0, 1, 9, 0));
		
		Mockito.when(appointmentRepository.save(testAppointment)).thenReturn(testAppointment);
		
		Appointment actual = appointmentService.saveAppointment(testAppointment);
		
		Appointment expected = testAppointment;
		
		assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testDeleteAppointment() {
		Appointment notSavedAppointment = new Appointment(1, new Date(2021, 0, 1), 1, 1, 1, new Date(1970, 0, 1, 8, 0),new Date(1970, 0, 1, 9, 0));
		
		Mockito.doNothing().when(appointmentRepository).delete(notSavedAppointment);
		
		boolean actual = appointmentService.deleteAppointment(1);
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testFindAppointmentsUsingFields() {
		List<Appointment> appointmentList = new ArrayList<>();
		Appointment testAppointment = new Appointment(1, new Date(2021, 0, 1), 1, 1, 1, new Date(1970, 0, 1, 8, 0),new Date(1970, 0, 1, 9, 0));
		Appointment testAppointment2 = new Appointment(2, new Date(2021, 0, 3), 1, 1, 1, new Date(1970, 0, 1, 10, 30),new Date(1970, 0, 1, 11, 30));
		
		appointmentList.add(testAppointment);
		appointmentList.add(testAppointment2);
		
		Appointment searchAppointment = new Appointment(null, null, null, null, null, null, null);
		
		Mockito.when(appointmentRepository.findByAPatientId(searchAppointment.getaPatientId())).thenReturn(appointmentList);
		
		Map<Integer, Appointment> actual = appointmentService.findAppointmentsUsingFields(searchAppointment);
		
		int expected = 0;
		
		assertEquals(expected, actual.size());
	}
}
