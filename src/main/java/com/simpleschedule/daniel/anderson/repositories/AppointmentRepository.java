package com.simpleschedule.daniel.anderson.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.simpleschedule.daniel.anderson.entities.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
	//FIND APPOINTMENT BY APPOINTMENT ID
	Appointment findByAId(Integer aId);
	
	//CUSTOM FINDER METHODS FOR ATTRIBUTES
	List<Appointment> findByAPatientId(Integer aPatientId);
	List<Appointment> findByADate(Date aDate);
	List<Appointment> findByATimeStart(Date aTimeStart);
	List<Appointment> findByALocationId(Integer aLocationId);
	List<Appointment> findByAPrimaryId(Integer aPrimaryId);
	
	List<Appointment> findByADateAndATimeStart(Date aDate, Date aTimeStart);
	List<Appointment> findByADateAndALocationId(Date aDate, Integer aLocationId);
	List<Appointment> findByADateAndAPrimaryId(Date aDate, Integer aPrimaryId);
	List<Appointment> findByATimeStartAndALocationId(Date aTimeStart, Integer aLocationId);
	List<Appointment> findByATimeStartAndAPrimaryId(Date aTimeStart, Integer aPrimaryId);
	List<Appointment> findByALocationIdAndAPrimaryId(Integer aLocationId, Integer aPrimaryId);
	
	List<Appointment> findByADateAndATimeStartAndALocationId(Date aDate, Date aTimeStart, Integer aLocationId);
	List<Appointment> findByADateAndATimeStartAndAPrimaryId(Date aDate, Date aTimeStart, Integer aPrimaryId);
	List<Appointment> findByADateAndALocationIdAndAPrimaryId(Date aDate, Integer aLocationId, Integer aPrimaryId);
	List<Appointment> findByATimeStartAndALocationIdAndAPrimaryId(Date aTimeStart, Integer aLocationId, Integer aPrimaryId);
	
	List<Appointment> findByADateAndATimeStartAndALocationIdAndAPrimaryId(Date aDate, Date aTimeStart, Integer aLocationId, Integer aPrimaryId);
}
