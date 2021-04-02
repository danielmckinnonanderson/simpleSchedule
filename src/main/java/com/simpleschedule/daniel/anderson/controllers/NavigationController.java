package com.simpleschedule.daniel.anderson.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.simpleschedule.daniel.anderson.entities.Patient;
import com.simpleschedule.daniel.anderson.services.StaffService;

@Controller
public class NavigationController {
	private StaffService staffService;

	
	public NavigationController(StaffService staffService) {
		super();
		this.staffService = staffService;
	}
	
	@GetMapping("/")
	public String showMainPage() {
		return "index";
	}
	
	@GetMapping("/patient_search")
	public String showPatientSearch(Model model) {
		model.addAttribute("doctorList", staffService.findAllDoctors());
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
