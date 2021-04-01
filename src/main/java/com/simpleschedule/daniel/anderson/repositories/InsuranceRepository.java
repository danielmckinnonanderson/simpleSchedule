package com.simpleschedule.daniel.anderson.repositories;

import org.springframework.data.repository.CrudRepository;

import com.simpleschedule.daniel.anderson.entities.Insurance;

public interface InsuranceRepository extends CrudRepository<Insurance, String> {
	
}
