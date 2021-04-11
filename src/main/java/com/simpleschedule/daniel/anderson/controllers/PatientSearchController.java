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
import org.springframework.web.bind.annotation.SessionAttribute;

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

	
	@Autowired
	public PatientSearchController(AppointmentService appointmentService, PatientService patientService,
			ContactService contactService, InsuranceService insuranceService) {
		this.appointmentService = appointmentService;
		this.contactService = contactService;
		this.insuranceService = insuranceService;
		this.patientService = patientService;
	}
	
	//search for a patient
	
	@GetMapping("/patient_search")
	public String showPatientSearch(Model model) {
		//initialize model attribute 'searchPatient' for data-binding form
		model.addAttribute("searchPatient", new Patient());
		return "patient_search";
	}
	
	//retrieve form inputs and bind to 'searchPatient'
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
		//query database using attribute values of searchPatient, set result list to model attribute 'resultsList'
		List<Patient> resultsList = patientService.findPatientUsingFields(searchPatient);
		model.addAttribute("resultsList", resultsList);
		return "patient_search_results";
	}
	
	//called when user selects a patient from results to view patient details
	@PostMapping("/patient_search_results")
	public String processViewPatientDetails(
			@RequestParam("viewId") Integer viewId,
			HttpSession session,
			Model model) {
		//find viewPatient using patient Id
		Patient viewPatient = patientService.findByPId(viewId); 
		//add session attributes for all of viewPatient's relevant info to be displayed on patient_details
		session.setAttribute("viewPatient", viewPatient);
		session.setAttribute("viewContact", contactService.findContactBycPatientId(viewId));
		session.setAttribute("viewInsurance", insuranceService.findByiPatientId(viewId));
		//TO DO: add location service to retrieve preferred location for this patient
		session.setAttribute("viewAppointments", appointmentService.findByAPatientId(viewId));
		return "patient_details";
	}
	
	//remove patient and all associated data from database
	//delete_patient prompts user to confirm choice to delete
	@GetMapping("/delete_patient")
	public String showDeletePatientForm() {
		return "delete_patient";
	}
	
	//called when user confirms deletion for selected patient
	@PostMapping("/delete_patient")
	public String deletePatient(
			@SessionAttribute("viewPatient") Patient viewPatient,
			@SessionAttribute("viewContact") Contact viewContact,
			@SessionAttribute("viewInsurance") Insurance viewInsurance) {
		//call service methods to delete patient, contact, and insurance
		contactService.deleteContact(viewContact);
		insuranceService.deleteInsurance(viewInsurance);
		appointmentService.deleteAllAppointmentsForPatient(viewPatient.getpId());
		patientService.deletePatient(viewPatient);
		//return to index
		return "index";
	}
	
	
	//update an existing patient
	
	//UPDATE PATIENT INFO
	@GetMapping("/update_info")
	public String updatePatientInfo(
			@SessionAttribute("viewPatient") Patient viewPatient,
			Model model) {
		//initialize model attribute 'updatePatient' for data-binding form
		model.addAttribute("updatePatient", new Patient());
		return "update_info";
	}
	
	//retrieve form inputs and bind to 'updatePatient'
	@PostMapping("/update_info")
	public String mergePatientInfo(
			@SessionAttribute("viewPatient") Patient oldPatient,
			@ModelAttribute("updatePatient") Patient updatePatient,
			BindingResult result,
			HttpSession session,
			Model model) {
		if (result.hasErrors()) {
			return "update_info";
		}
		//assign 'viewPatient' to 'oldPatient' to compare attributes for update
		//call patient service method to parse null values and update non-null fields for patient
		Patient updatedPatient = patientService.updatePatient(oldPatient, updatePatient);
		
		//set updated Patient to session attribute 'viewPatient' for viewing on patient_details
		session.setAttribute("viewPatient", updatedPatient);
		
		//send back to patient_details
		return "patient_details";
	}
	
	//UPDATE CONTACT INFO
	@GetMapping("/update_contact")
	public String updatePatientContact(
			@SessionAttribute("viewContact") Contact viewContact,
			Model model) {
		//initialize model attribute 'updateContact' for data-binding form
		model.addAttribute("updateContact", new Contact());
		return "update_contact";
	}
	
	//retrieve form inputs and bind to 'updateContact'
	@PostMapping("/update_contact")
	public String mergePatientContact(
			@ModelAttribute("updateContact") Contact updateContact,
			BindingResult result,
			HttpSession session,
			Model model) {
		if (result.hasErrors()) {
			return "update_contact";
		}
		//assign 'viewContact' to 'oldContact' to compare attributes for update
		//call contact service method to update contact
		Contact updatedContact = contactService.updateContact(updateContact);
		
		//set updatedContact to session attribute 'viewContact' for viewing on patient_details
		session.setAttribute("viewContact", updatedContact);
		
		//send back to patient_details
		return "patient_details";
	}
	
	//UPDATE INSURANCE INFO
	@GetMapping("/update_insurance")
	public String updatePatientInsurance(
			@SessionAttribute("viewInsurance") Insurance viewInsurance,
			Model model) {
		//initialize model attribute 'updateInsurance' for data-binding form
		model.addAttribute("updateInsurance", new Insurance());
		return "update_insurance";
	}
	
	//retrieve form inputs and bind to 'updateInsurance'
	@PostMapping("/update_insurance")
	public String mergePatientInsurance(
			@ModelAttribute("updateInsurance") Insurance updateInsurance,
			BindingResult result,
			HttpSession session,
			Model model) {
		if (result.hasErrors()) {
			return "update_contact";
		}
		//assign 'viewInsurance' to 'oldInsurance' to compare attributes for update
		//call insurance service method to update insurance
		Insurance updatedInsurance = insuranceService.updateInsurance(updateInsurance);
		
		//set updatedInsurance to session attribute 'viewInsurance' for viewing on patient_details
		session.setAttribute("viewInsurance", updatedInsurance);
		return "patient_details";
	}
}
