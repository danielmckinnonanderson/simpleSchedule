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

import com.simpleschedule.daniel.anderson.entities.Patient;
import com.simpleschedule.daniel.anderson.entities.Staff;
import com.simpleschedule.daniel.anderson.services.PatientService;
import com.simpleschedule.daniel.anderson.services.StaffService;

@Controller
public class PatientSearchController {
	private PatientService patientService;
	private StaffService staffService;
	
	@Autowired
	public PatientSearchController(PatientService patientService, StaffService staffService) {
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
		if (result.hasErrors()) {
			return "patient_search";
		}

		List<Patient> resultsList = patientService.findPatientUsingFields(searchPatient);
		model.addAttribute("resultsList", resultsList);
		
		return "search_results";
	}
}
