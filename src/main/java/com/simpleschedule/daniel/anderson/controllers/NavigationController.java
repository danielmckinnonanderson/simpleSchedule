package com.simpleschedule.daniel.anderson.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

	
	public NavigationController() {
		super();
	}
	
	@GetMapping("/")
	public String showMainPage() {
		return "index";
	}
	
	@GetMapping("/patient_search")
	public String showPatientSearch() {
		return "patient_search";
	}
	
	@GetMapping("/patient_add")
	public String showPatientAdd() {
		return "patient_add";
	}
	
	@GetMapping("/appointment_search")
	public String showAppointmentSearch() {
		return "appointment_search";
	}
	
	@GetMapping("/appointment_add")
	public String showAppointmentAdd() {
		return "appointment_add";
	}
}
