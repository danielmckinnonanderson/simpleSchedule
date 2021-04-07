package com.simpleschedule.daniel.anderson.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simpleschedule.daniel.anderson.entities.Contact;
import com.simpleschedule.daniel.anderson.entities.Insurance;
import com.simpleschedule.daniel.anderson.entities.Patient;
import com.simpleschedule.daniel.anderson.entities.Staff;
import com.simpleschedule.daniel.anderson.exceptions.EntityNotFoundException;
import com.simpleschedule.daniel.anderson.services.AppointmentService;
import com.simpleschedule.daniel.anderson.services.ContactService;
import com.simpleschedule.daniel.anderson.services.InsuranceService;
import com.simpleschedule.daniel.anderson.services.PatientService;
import com.simpleschedule.daniel.anderson.services.StaffService;

@Controller
public class PatientSearchController {
	private AppointmentService appointmentService;
	private ContactService contactService;
	private InsuranceService insuranceService;
	private PatientService patientService;
	private StaffService staffService;
	
	@Autowired
	public PatientSearchController(AppointmentService appointmentService, PatientService patientService, StaffService staffService,
			ContactService contactService, InsuranceService insuranceService) {
		this.appointmentService = appointmentService;
		this.contactService = contactService;
		this.insuranceService = insuranceService;
		this.patientService = patientService;
		this.staffService = staffService;
	}
	
	@GetMapping("/patient_search")
	public String showPatientSearch(Model model, HttpSession session) {
		if (session.getAttribute("doctorList") == null) {
			List<Staff> doctorList = staffService.findAllDoctors();
			session.setAttribute("doctorList", doctorList);
		}
		model.addAttribute("searchPatient", new Patient());
		return "patient_search";
	}
	
	
	@PostMapping("/patient_search")
	public String processPatientSearch(
			@ModelAttribute("searchPatient") Patient searchPatient,
			BindingResult result,
			Model model) {
		model.addAttribute("hasErrors", result.hasErrors());
		if (result.hasErrors()) {
			model.addAttribute("error", result.getFieldError());
			return "patient_search";
		}
		List<Patient> resultsList = patientService.findPatientUsingFields(searchPatient);
		model.addAttribute("resultsList", resultsList);

		return "patient_search_results";
	}
	
	@PostMapping("/patient_search_results")
	public String processViewPatientDetails(
			@RequestParam("viewId") Integer viewId,
			HttpSession session,
			Model model) {
		
		Patient viewPatient = patientService.findByPId(viewId); 
		
		if (viewPatient == null) {
			try {
				throw new EntityNotFoundException("Patient not found under specified ID");
			} catch (EntityNotFoundException enfe) {
				System.out.println(enfe.getMessage());
			}
			return "index";
		} else {

			session.setAttribute("viewPatient", viewPatient);
			model.addAttribute("viewContact", contactService.findContactBycPatientId(viewId));
			model.addAttribute("viewInsurance", insuranceService.findByiPatientId(viewId));
			//TO DO: add location service to retrieve preferred location for this patient
			session.setAttribute("viewAppointments", appointmentService.findByAPatientId(viewId));
			return "patient_details";
		}
	}
}
