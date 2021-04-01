package com.simpleschedule.daniel.anderson.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.simpleschedule.daniel.anderson.entities.Staff;

public interface StaffRepository extends CrudRepository<Staff, Integer>{
	List<Staff> findByTitle(String sTitle);
}
