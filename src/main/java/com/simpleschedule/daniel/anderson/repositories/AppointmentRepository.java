package com.simpleschedule.daniel.anderson.repositories;

import org.springframework.data.repository.CrudRepository;

import com.simpleschedule.daniel.anderson.entities.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

}
