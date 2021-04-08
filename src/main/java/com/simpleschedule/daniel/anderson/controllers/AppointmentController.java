package com.simpleschedule.daniel.anderson.controllers;


import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.simpleschedule.daniel.anderson.entities.Appointment;
import com.simpleschedule.daniel.anderson.entities.Location;
import com.simpleschedule.daniel.anderson.entities.Patient;
import com.simpleschedule.daniel.anderson.entities.Staff;
import com.simpleschedule.daniel.anderson.services.AppointmentService;

@Controller
public class AppointmentController {
	private AppointmentService appointmentService;
	
	@Autowired
	public AppointmentController(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	
	@GetMapping("/appointment_search")
	public String showAppointmentSearch(
			@SessionAttribute(required=true, name="locationMap") HashMap<Integer, Location> locationMap,
			@SessionAttribute(required=true, name="doctorList") List<Staff> doctorList,
			Model model) {
		model.addAttribute("searchAppointment", new Appointment());
		return "appointment_search";
	}
	
	@PostMapping("/appointment_search")
	public String processAppointmentSearch(
			@ModelAttribute("searchAttribute") Appointment searchAppointment,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "appointment_search";
		}
		System.out.println(searchAppointment);
		List<Appointment> resultsList = appointmentService.findAppointmentUsingFields(searchAppointment);
		model.addAttribute("resultsList", resultsList);
		return "appointment_search_results";
	}
	
	@GetMapping("/appointment_add")
	public String showAppointmentAdd(
			@SessionAttribute(required=true, name="locationMap") HashMap<Integer, Location> locationMap,
			@SessionAttribute(required=true, name="doctorList") List<Staff> doctorList,
			@SessionAttribute("viewPatient") Patient viewPatient,
			Model model) {
		model.addAttribute("newAppointment", new Appointment());
		System.out.println(viewPatient);
		return "appointment_add";
	}
	
	@PostMapping("/appointment_add")
	public String processNewAppointment(
			@ModelAttribute("newAppointment") Appointment newAppointment,
			BindingResult result,
			@SessionAttribute("viewPatient") Patient viewPatient,
			@SessionAttribute(required=true, name="locationMap") HashMap<Integer, Location> locationMap,
			HttpSession session,
			Model model) {
		model.addAttribute("hasErrors", result.hasErrors());
		if (result.hasErrors()) {
			System.out.println("Has Errors: " + result.hasErrors());
			return "/appointment_add";
		}
		//persist newAppointment to the database
		Appointment savedAppointment = appointmentService.saveAppointment(newAppointment);
		System.out.println(savedAppointment);
		
		session.setAttribute("appointmentList", appointmentService.findByAPatientId(viewPatient.getpId()));
		return "patient_details";
	}
}
