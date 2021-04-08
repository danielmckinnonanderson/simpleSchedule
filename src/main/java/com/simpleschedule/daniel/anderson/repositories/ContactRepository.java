package com.simpleschedule.daniel.anderson.repositories;

import org.springframework.data.repository.CrudRepository;

import com.simpleschedule.daniel.anderson.entities.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
	Contact findByCPatientId(Integer cPatientId);
}
