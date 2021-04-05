
package com.simpleschedule.daniel.anderson.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.simpleschedule.daniel.anderson.entities.Contact;
import com.simpleschedule.daniel.anderson.entities.Insurance;
import com.simpleschedule.daniel.anderson.entities.Patient;
import com.simpleschedule.daniel.anderson.entities.Staff;
import com.simpleschedule.daniel.anderson.services.ContactService;
import com.simpleschedule.daniel.anderson.services.InsuranceService;
import com.simpleschedule.daniel.anderson.services.PatientService;
import com.simpleschedule.daniel.anderson.services.StaffService;

@Controller
public class PatientAddController {
	private PatientService patientService;
	private StaffService staffService;
	private ContactService contactService;
	private InsuranceService insuranceService;
	
	@Autowired
	public PatientAddController(PatientService patientService, StaffService staffService, 
			ContactService contactService, InsuranceService insuranceService) {
		this.patientService = patientService;
		this.staffService = staffService;
		this.contactService = contactService;
		this.insuranceService = insuranceService;
	}
	
	@GetMapping("/patient_add")
	public String showPatientAdd(Model model, HttpSession session) {
		if (session.getAttribute("doctorList") == null) {
			List<Staff> doctorList = staffService.findAllDoctors();
			session.setAttribute("doctorList", doctorList);
		}
		model.addAttribute("newPatient", new Patient());
		model.addAttribute("newInsurance", new Insurance());
		model.addAttribute("newContact", new Contact());
		return "patient_add";
	}
	
	@PostMapping("/patient_add")
	public String processNewPatient(
			@Valid @ModelAttribute("newPatient") Patient newPatient,
			@Valid @ModelAttribute("newInsurance") Insurance newInsurance,
			@Valid @ModelAttribute("newContact") Contact newContact,
			BindingResult result,
			Model model) { 
		if (result.hasErrors()) {
			return "patient_add";
		}
		System.out.println("BEFORE SAVE: " + newPatient);
		newPatient = patientService.saveNewPatient(newPatient);
		System.out.println("POST SAVE: " + newPatient);
		
		System.out.println("CONTACT " + newContact);
		newContact.setcPatientId(newPatient.getpId());
		contactService.saveNewContact(newContact);
		
		System.out.println("INSURANCE: " + newInsurance);
		newInsurance.setiPatientId(newPatient.getpId());
		insuranceService.saveNewInsurance(newInsurance);
		
		return "index";
	}

}