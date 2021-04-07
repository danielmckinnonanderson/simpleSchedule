package com.simpleschedule.daniel.anderson.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public String processNewAppointment(@ModelAttribute("newAppointment") Appointment newAppointment,
			BindingResult result,
			@SessionAttribute("viewPatient") Patient viewPatient,
			@SessionAttribute(required=true, name="locationMap") HashMap<Integer, Location> locationMap,
			Model model) {
		model.addAttribute("hasErrors", result.hasErrors());
		System.out.println("appointment: " + newAppointment);
		if (result.hasErrors()) {
			System.out.println("Has Errors: " + result.hasErrors());
			return "/appointment_add";
		}
		System.out.println(newAppointment);
		//add viewPatient.pId to newAppointment
		newAppointment.setaPatientId(viewPatient.getpId());
		
		//persist newAppointment to the database
		appointmentService.saveAppointment(newAppointment);
		
		model.addAttribute("appointmentList", appointmentService.findByAPatientId(viewPatient.getpId()));
		return "redirect:patient_details";
	}
}
