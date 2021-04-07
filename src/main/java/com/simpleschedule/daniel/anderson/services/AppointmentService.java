package com.simpleschedule.daniel.anderson.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleschedule.daniel.anderson.entities.Appointment;
import com.simpleschedule.daniel.anderson.repositories.AppointmentRepository;

@Service
public class AppointmentService {
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	public AppointmentService(AppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}
	
	//GET ALL APPOINTMENTS FOR SPECIFIED PATIENT
	public List<Appointment> findByAPatientId(Integer aPatientId) {
		return appointmentRepository.findByaPatientId(aPatientId);
	}
	
	//ADD A NEW APPOINTMENT TO THE DATABASE
	public Appointment saveAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}
}