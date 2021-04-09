
package com.simpleschedule.daniel.anderson.controllers;

import javax.servlet.http.HttpSession;

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
import com.simpleschedule.daniel.anderson.services.ContactService;
import com.simpleschedule.daniel.anderson.services.InsuranceService;
import com.simpleschedule.daniel.anderson.services.PatientService;

@Controller
public class PatientAddController {
	private PatientService patientService;
	private ContactService contactService;
	private InsuranceService insuranceService;
	
	@Autowired
	public PatientAddController(PatientService patientService, 
			ContactService contactService, InsuranceService insuranceService) {
		this.patientService = patientService;
		this.contactService = contactService;
		this.insuranceService = insuranceService;
	}
	
	//Add a new patient to the database
	
	@GetMapping("/patient_add")
	public String showPatientAdd(Model model, HttpSession session) {
		//initialize model attribute 'newPatient' for data-binding form
		model.addAttribute("newPatient", new Patient());
		return "patient_add";
	}
	
	//retrieve form inputs and bind to 'newPatient'
	@PostMapping("/patient_add")
	public String processNewPatient(
			@ModelAttribute("newPatient") Patient newPatient,
			BindingResult result,
			HttpSession session,
			Model model) { 
		if (result.hasErrors()) {
			return "patient_add";
		}
		//set session attribute 'newPatient' equal to the retrieved newPatient object from spring-form
		session.setAttribute("newPatient", newPatient);
		return "redirect:patient_add_insurance";
	}
	
	//Add insurance for new patient to the database
	@GetMapping("/patient_add_insurance")
	public String showNewInsurance(Model model) {
		//initialize model attribute 'newInsurance' for data-binding form
		model.addAttribute("newInsurance", new Insurance());
		return "patient_add_insurance";
	}
	
	//retrieve form inputs and bind to 'newInsurance'
	@PostMapping("/patient_add_insurance")
	public String processNewInsurance(
			@ModelAttribute("newInsurance") Insurance newInsurance,
			BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "patient_add_insurance";
		}
		//set session attribute 'newInsurance' equal to the retrieved newInsurance object from spring-form
		session.setAttribute("newInsurance", newInsurance);
		return "redirect:patient_add_contact";
	}
	
	//Add contact for new patient to the database
	@GetMapping("/patient_add_contact")
	public String showNewContact(Model model) {
		//initialize model attribute 'newContact' for data-binding form
		model.addAttribute("newContact", new Contact());
		return "patient_add_contact";
	}
	
	//retrieve form inputs and bind to 'newContact'
	//If valid, persist patient, insurance, and contact together before directing to patient_details page for viewing
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
		//persist newPatient to database
		newPatient = patientService.saveNewPatient(newPatient);
		//get newly auto-generated ID for patient from database
		Integer pId = newPatient.getpId();
		
		//set patientId for contact and insurance equal to newPatient's pId
		newContact.setcPatientId(pId);
		newInsurance.setiPatientId(pId);
		
		//persist new contact and insurance to database
		contactService.saveNewContact(newContact);
		insuranceService.saveNewInsurance(newInsurance);
		
		//assign patient, contact, and service to session attributes for patient_details page
		session.setAttribute("viewPatient", newPatient);
		session.setAttribute("viewContact", newContact);
		session.setAttribute("viewInsurance", newInsurance);
		
		//remove no-longer necessary session attributes
		session.removeAttribute("newPatient");
		session.removeAttribute("newInsurance");
		session.removeAttribute("newContact");
		
		return "patient_details";
	}
}