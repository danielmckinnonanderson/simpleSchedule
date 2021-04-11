package com.simpleschedule.daniel.anderson.controllers;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import com.simpleschedule.daniel.anderson.entities.Location;
import com.simpleschedule.daniel.anderson.entities.Staff;
import com.simpleschedule.daniel.anderson.services.LocationService;
import com.simpleschedule.daniel.anderson.services.PatientService;
import com.simpleschedule.daniel.anderson.services.StaffService;

@Controller
public class NavigationController {
	private LocationService locationService;
	private PatientService patientService;
	private StaffService staffService;

	@Autowired
	public NavigationController(LocationService locationService, PatientService patientService, StaffService staffService) {
		this.locationService = locationService;
		this.patientService = patientService;
		this.staffService = staffService;
	}

	@GetMapping("/")
	public String showMainPage(HttpSession session) {
		// if session attribute 'doctorList' is not yet initialized, call staffService method and set it
		if (session.getAttribute("doctorList") == null) {
			List<Staff> doctorList = staffService.findAllDoctors();
			session.setAttribute("doctorList", doctorList);
		}
		// if session attribute 'locationMap' is not yet initialized, call locationService method and set it
		if (session.getAttribute("locationMap") == null) {
			HashMap<Integer, Location> locationMap = locationService.getAll();
			session.setAttribute("locationMap", locationMap);
		}
		
		//get all patients and set resultlist to session attribute 'allPatients'
		session.setAttribute("allPatients", patientService.getAllPatients());
		
		//remove all session attributes set by searches
		//create array list of values to be removed
		String[] removeThese = {"appointmentList", "newContact", "newInsurance", "newPatient", 
				"viewAppointments", "viewContact",
				"viewInsurance", "viewPatient"};
		
		//iterate through array, check if session attribute is not null, and remove if so
		for (String attribute : removeThese) {
			if (session.getAttribute(attribute) != null ) {
				session.removeAttribute(attribute);
			}
		}
		
		return "index";
	}
}