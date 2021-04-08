
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
import org.springframework.web.bind.annotation.SessionAttribute;

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
		return "patient_add";
	}
	
	@PostMapping("/patient_add")
	public String processNewPatient(
			@ModelAttribute("newPatient") Patient newPatient,
			BindingResult result,
			HttpSession session,
			Model model) { 
		if (result.hasErrors()) {
			return "patient_add";
		}
		session.setAttribute("newPatient", newPatient);
		return "redirect:patient_add_insurance";
	}
	
	@GetMapping("/patient_add_insurance")
	public String showNewInsurance(Model model) {
		model.addAttribute("newInsurance", new Insurance());
		return "patient_add_insurance";
	}
	
	@PostMapping("/patient_add_insurance")
	public String processNewInsurance(
			@ModelAttribute("newInsurance") Insurance newInsurance,
			BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "patient_add_insurance";
		}
		session.setAttribute("newInsurance", newInsurance);
		return "redirect:patient_add_contact";
	}
	
	@GetMapping("/patient_add_contact")
	public String showNewContact(Model model) {
		model.addAttribute("newContact", new Contact());
		return "patient_add_contact";
	}
	
	@PostMapping("/patient_add_contact")
	public String processNewContact(
			@SessionAttribute("newPatient") Patient newPatient,
			@SessionAttribute("newInsurance") Insurance newInsurance,
			@ModelAttribute("newContact") Contact newContact,
			BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "patient_add_contact";
		}
		System.out.println("---> @PostMapping(/patient_add_contact)");
		System.out.println("newContact: " + newContact);
		
		//persist new patient to db
		newPatient = patientService.saveNewPatient(newPatient);
		//get newly generated ID for patient from Db
		Integer pId = newPatient.getpId();
		
		//set patientId for contact and insurance equal to pId
		newContact.setcPatientId(pId);
		newInsurance.setiPatientId(pId);
		
		//persist new contact and insurance to db
		contactService.saveNewContact(newContact);
		insuranceService.saveNewInsurance(newInsurance);
		
		//assign patient, contact, and service to 'view' session attributes for patient_details page
		session.setAttribute("viewPatient", newPatient);
		session.setAttribute("viewContact", newContact);
		session.setAttribute("viewInsurance", newInsurance);
		
		return "patient_details";
	}
}