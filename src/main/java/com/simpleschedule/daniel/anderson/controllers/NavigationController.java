package com.simpleschedule.daniel.anderson.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

	@Autowired
	public NavigationController() {
		super();
	}

	@GetMapping("/")
	public String showMainPage() {
		return "index";
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
