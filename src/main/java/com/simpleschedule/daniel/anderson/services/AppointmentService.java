package com.simpleschedule.daniel.anderson.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public Appointment findByAId(Integer aId) {
		return appointmentRepository.findByAId(aId);
	}
	
	//GET ALL APPOINTMENTS FOR SPECIFIED PATIENT
	public Map<Integer, Appointment> findByAPatientId(Integer aPatientId) {
		Map<Integer, Appointment> appointmentMap = new HashMap<>();
		for (Appointment appointment : appointmentRepository.findByAPatientId(aPatientId)) {
			System.out.println(appointment);
			appointmentMap.put(appointment.getaId(), appointment);
		}
		return appointmentMap;	
	}
	
	//ADD A NEW APPOINTMENT TO THE DATABASE
	public Appointment saveAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}
	
	//DELETE AN APPOINTMENT
	public void deleteAppointment(Integer aId) {
		appointmentRepository.deleteById(aId);
	}
	
	//PUBLIC METHOD RETURNING MAP
	public Map<Integer, Appointment> findAppointmentsUsingFields(Appointment searchAppointment) {
		Map<Integer, Appointment> appointmentMap = new HashMap<>();
		for (Appointment appointment : findAppointmentUsingFields(searchAppointment)) {
			appointmentMap.put(appointment.getaId(), appointment);
		}
		return appointmentMap;
	}
	
	//METHOD FOR DISCERNING USER INPUTS AND CALLING APPROPRIATE QUERY METHOD
	private List<Appointment> findAppointmentUsingFields(Appointment appointment) {
		if (appointment.getaDate() != null && appointment.getaTimeStart() != null && appointment.getaLocationId() != null && appointment.getaPrimaryId() != null) {
			return findByADateAndATimeStartAndALocationIdAndAPrimaryId(appointment.getaDate(), appointment.getaTimeStart(), appointment.getaLocationId(), appointment.getaPrimaryId());
		} else if (appointment.getaDate() != null && appointment.getaTimeStart() != null && appointment.getaLocationId() != null) {
			return findByADateAndATimeStartAndALocationId(appointment.getaDate(), appointment.getaTimeStart(), appointment.getaLocationId());
		} else if (appointment.getaDate() != null && appointment.getaTimeStart() != null && appointment.getaPrimaryId() != null) {
			return findByADateAndATimeStartAndAPrimaryId(appointment.getaDate(), appointment.getaTimeStart(), appointment.getaPrimaryId());
		} else if (appointment.getaDate() != null && appointment.getaLocationId() != null && appointment.getaPrimaryId() != null) {
			return findByADateAndALocationIdAndAPrimaryId(appointment.getaDate(), appointment.getaLocationId(), appointment.getaPrimaryId());
		} else if (appointment.getaTimeStart() != null && appointment.getaLocationId() != null && appointment.getaPrimaryId() != null) {
			return findByATimeStartAndALocationIdAndAPrimaryId(appointment.getaTimeStart(), appointment.getaLocationId(), appointment.getaPrimaryId());
		} else if (appointment.getaDate() != null && appointment.getaTimeStart() != null) {
			return findByADateAndATimeStart(appointment.getaDate(), appointment.getaTimeStart());
		} else if (appointment.getaDate() != null && appointment.getaLocationId() != null) {
			return findByADateAndALocationId(appointment.getaDate(), appointment.getaLocationId());
		} else if (appointment.getaDate() != null && appointment.getaPrimaryId() != null) {
			return findByADateAndAPrimaryId(appointment.getaDate(), appointment.getaPrimaryId());
		} else if (appointment.getaTimeStart() != null && appointment.getaLocationId() != null) {
			return findByATimeStartAndALocationId(appointment.getaTimeStart(), appointment.getaLocationId());
		} else if (appointment.getaTimeStart() != null && appointment.getaPrimaryId() != null) {
			return findByATimeStartAndAPrimaryId(appointment.getaTimeStart(), appointment.getaPrimaryId());
		} else if (appointment.getaLocationId() != null && appointment.getaPrimaryId() != null) {
			return findByALocationIdAndAPrimaryId(appointment.getaLocationId(), appointment.getaPrimaryId());
		} else if (appointment.getaDate() != null) {
			return findByADate(appointment.getaDate());
		} else if (appointment.getaTimeStart() != null) {
			return findByATimeStart(appointment.getaTimeStart());
		} else if (appointment.getaLocationId() != null) {
			return findByALocationId(appointment.getaLocationId());
		} else if (appointment.getaPrimaryId() != null) {
			return findByAPrimaryId(appointment.getaPrimaryId());
		} else {
			System.out.println("No Fields Provided");
			return null;
		}
	} 
	
	//PRIVATE FINDER METHODS FOR ATTRIBUTES CALLED BY findAppointmentUsingFields
	private List<Appointment> findByADate(Date aDate) {
		return appointmentRepository.findByADate(aDate);
	}
	private List<Appointment> findByATimeStart(Date aTimeStart) {
		return appointmentRepository.findByATimeStart(aTimeStart);
	}
	private List<Appointment> findByALocationId(Integer aLocationId) {
		return appointmentRepository.findByALocationId(aLocationId);
	}
	private List<Appointment> findByAPrimaryId(Integer aPrimaryId) {
		return appointmentRepository.findByAPrimaryId(aPrimaryId);
	}
	private List<Appointment> findByADateAndATimeStart(Date aDate, Date aTimeStart) {
		return appointmentRepository.findByADateAndATimeStart(aDate, aTimeStart);
	}
	private List<Appointment> findByADateAndALocationId(Date aDate, Integer aLocationId) {
		return appointmentRepository.findByADateAndALocationId(aDate, aLocationId);
	}
	private List<Appointment> findByADateAndAPrimaryId(Date aDate, Integer aPrimaryId) {
		return appointmentRepository.findByADateAndAPrimaryId(aDate, aPrimaryId);
	}
	private List<Appointment> findByATimeStartAndALocationId(Date aTimeStart, Integer aLocationId) {
		return appointmentRepository.findByADateAndALocationId(aTimeStart, aLocationId);
	}
	private List<Appointment> findByATimeStartAndAPrimaryId(Date aTimeStart, Integer aPrimaryId) {
		return appointmentRepository.findByADateAndAPrimaryId(aTimeStart, aPrimaryId);
	}
	private List<Appointment> findByALocationIdAndAPrimaryId(Integer aLocationId, Integer aPrimaryId) {
		return appointmentRepository.findByALocationIdAndAPrimaryId(aLocationId, aPrimaryId);
	}
	private List<Appointment> findByADateAndATimeStartAndALocationId(Date aDate, Date aTimeStart, Integer aLocationId) {
		return appointmentRepository.findByADateAndATimeStartAndALocationId(aDate, aTimeStart, aLocationId);
	}
	private List<Appointment> findByADateAndATimeStartAndAPrimaryId(Date aDate, Date aTimeStart, Integer aPrimaryId) {
		return appointmentRepository.findByADateAndATimeStartAndAPrimaryId(aDate, aTimeStart, aPrimaryId);
	}
	private List<Appointment> findByADateAndALocationIdAndAPrimaryId(Date aDate, Integer aLocationId, Integer aPrimaryId) {
		return appointmentRepository.findByADateAndALocationIdAndAPrimaryId(aDate, aLocationId, aPrimaryId);
	}
	private List<Appointment> findByATimeStartAndALocationIdAndAPrimaryId(Date aTimeStart, Integer aLocationId, Integer aPrimaryId) {
		return appointmentRepository.findByATimeStartAndALocationIdAndAPrimaryId(aTimeStart, aLocationId, aPrimaryId);
	}
	private List<Appointment> findByADateAndATimeStartAndALocationIdAndAPrimaryId(Date aDate, Date aTimeStart, Integer aLocationId, Integer aPrimaryId) {
		return appointmentRepository.findByADateAndATimeStartAndALocationIdAndAPrimaryId(aDate, aTimeStart, aLocationId, aPrimaryId);
	}
}