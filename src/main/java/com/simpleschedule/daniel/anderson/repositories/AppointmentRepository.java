package com.simpleschedule.daniel.anderson.repositories;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.simpleschedule.daniel.anderson.entities.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
	//FIND APPOINTMENTS BY COLUMN
	Appointment findByAId(Integer aId);
	List<Appointment> findByaPatientId(Integer aPatientId);
//	List<Appointment> findByADateByOrderByATimeStart(Date aDate);
//	List<Appointment> findByaPrimaryIdByOrderByADate(Integer aPrimaryId);
	
	//FIND APPOINTMENTS BY COMBINTATION OF COLUMNS
	List<Appointment> findByADateAndATimeStart(Date aDate, LocalDateTime aTimeStart);
}
