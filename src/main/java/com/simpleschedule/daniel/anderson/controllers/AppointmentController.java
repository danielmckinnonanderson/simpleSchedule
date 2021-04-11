package com.simpleschedule.daniel.anderson.controllers;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.simpleschedule.daniel.anderson.entities.Appointment;
import com.simpleschedule.daniel.anderson.entities.Patient;
import com.simpleschedule.daniel.anderson.services.AppointmentService;

@Controller
public class AppointmentController {
	private AppointmentService appointmentService;
	
	@Autowired
	public AppointmentController(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	
	//search for an appointment
	
	@GetMapping("/appointment_search")
	public String showAppointmentSearch(
			Model model) {
		//initialize model attribute 'searchAppointment' for data-binding form
		model.addAttribute("searchAppointment", new Appointment());
		return "appointment_search";
	}
	
	//retrieve form inputs and bind to 'searchAppointment'
	@PostMapping("/appointment_search")
	public String processAppointmentSearch(
			@ModelAttribute("searchAttribute") Appointment searchAppointment,
			BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "appointment_search";
		}
		//query database using 'searchAppointment's attributes and set result list to session attribute 'appointmentList'
		session.setAttribute("appointmentList", appointmentService.findAppointmentsUsingFields(searchAppointment));
		
		return "appointment_search_results";
	}
	
	//add a new appointment
	
	@GetMapping("/appointment_add")
	public String showAppointmentAdd(
			@SessionAttribute("viewPatient") Patient viewPatient,
			Model model) {
		//initialize model attribute 'newAppointment' for data-binding form
		model.addAttribute("newAppointment", new Appointment());
		return "appointment_add";
	}
	
	//retrieve form inputs and bind to 'newAppointment'
	@PostMapping("/appointment_add")
	public String processNewAppointment(
			@ModelAttribute("newAppointment") Appointment newAppointment,
			BindingResult result,
			@SessionAttribute("viewPatient") Patient viewPatient,
			HttpSession session,
			Model model) {
		model.addAttribute("hasErrors", result.hasErrors());
		if (result.hasErrors()) {
			System.out.println("Has Errors: " + result.hasErrors());
			return "/appointment_add";
		}
		//persist newAppointment to the database
		appointmentService.saveAppointment(newAppointment);
		//re-fetch list of patient's appointments to be displayed on patient_details
		session.setAttribute("viewAppointments", appointmentService.findByAPatientId(viewPatient.getpId()));
		return "patient_details";
	}
	
	//delete an appointment
	
	@GetMapping("/delete_appointment")
	public String showDeleteAppointmentForm(
			@RequestParam("appointmentId") Integer aId,
			@SessionAttribute(required=false, name="allPatients") Map<Integer, Patient> allPatients,
			@SessionAttribute(required=false, name="appointmentList") Map<Integer, Appointment> appointmentList,
			@SessionAttribute(required=false, name="viewAppointments") Map<Integer, Appointment> viewAppointments,
			HttpSession session,
			Model model) {
		//add parameter aId of selected appointment to model
		model.addAttribute("aId", aId);
		
		//depending on which page directed to the delete request, get appropriate Map<Integer, Appointment>
		if (appointmentList.size() > 0) {
			//retrieve value of appointment from appointmentList with aId, set value to model attribute 'deleteAppointment'
			model.addAttribute("deleteAppointment", appointmentList.get(aId));
			//set value of 'viewPatient' session attribute equal to patientId of deleteAppointment
			session.setAttribute("viewPatient", allPatients.get(appointmentList.get(aId).getaPatientId()));
		} else if (viewAppointments.size() > 0) {
			//retrieve value of appointment from appointmentList with aId, set value to model attribute 'deleteAppointment'
			model.addAttribute("deleteAppointment", viewAppointments.get(aId));
		}
		//send to delete_appointment to prompt user to confirm deletion
		return "delete_appointment";
	}
	
	//if user confirms deletion, proceed
	@PostMapping("/delete_appointment")
	public String deleteAppointment(
			@RequestParam("aId") Integer aId,
			Model model) {
		//call service method to delete appointment by appointmentId
		appointmentService.deleteAppointment(aId);
		//send user back to homepage
		return "redirect:/";
	}
}
