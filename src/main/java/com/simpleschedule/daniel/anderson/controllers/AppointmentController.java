package com.simpleschedule.daniel.anderson.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.simpleschedule.daniel.anderson.services.AppointmentService;

@Controller
public class AppointmentController {
	private AppointmentService appointmentService;
	
	@Autowired
	public AppointmentController(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	
	@GetMapping("/appointment_add")
	public String showAppointmentAdd() {
		return "appointment_add";
	}
	
	@PostMapping("/appointment_add")
	public String processNewAppointment() {
		return "";
	}
}
