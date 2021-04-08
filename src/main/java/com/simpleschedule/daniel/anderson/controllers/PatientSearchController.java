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
		//find viewPatient using patient Id
		Patient viewPatient = patientService.findByPId(viewId); 
		//if viewPatient does not exist throw exception
		if (viewPatient == null) {
			try {
				throw new EntityNotFoundException("Patient not found under specified ID");
			} catch (EntityNotFoundException enfe) {
				System.out.println(enfe.getMessage());
			}
			return "index";
		} else {
			//add session attributes for all of viewPatient's relevant info to be displayed on patient_details
			session.setAttribute("viewPatient", viewPatient);
			session.setAttribute("viewContact", contactService.findContactBycPatientId(viewId));
			session.setAttribute("viewInsurance", insuranceService.findByiPatientId(viewId));
			//TO DO: add location service to retrieve preferred location for this patient
			session.setAttribute("viewAppointments", appointmentService.findByAPatientId(viewId));
			return "patient_details";
		}
	}
	
	//REQUEST METHODS FOR DELETING A PATIENT AND THEIR RELEVANT INFO
	@GetMapping("/delete_patient")
	public String showDeletePatientForm() {
		return "delete_patient";
	}
	
	
	@PostMapping("/delete_patient")
	public String deletePatient(
			@SessionAttribute("viewPatient") Patient viewPatient,
			@SessionAttribute("viewContact") Contact viewContact,
			@SessionAttribute("viewInsurance") Insurance viewInsurance) {
		//call service methods to delete patient, contact, and insurance
		contactService.deleteContact(viewContact);
		insuranceService.deleteInsurance(viewInsurance);
		patientService.deletePatient(viewPatient);
		//return to index
		return "index";
	}
	
	
	//REQUEST METHODS CALLED FOR UPDATING SECTIONS ON THE PATIENT_DETAILS PAGE
	
	//UPDATE PATIENT INFO
	@GetMapping("/update_info")
	public String updatePatientInfo(
			@SessionAttribute("viewPatient") Patient viewPatient,
			Model model) {
		//add model attribute to store updated information
		model.addAttribute("updatePatient", new Patient());
		return "update_info";
	}
	
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
		System.out.println("updatePatient: " + updatePatient);
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
		model.addAttribute("updateContact", new Contact());
		return "update_contact";
	}
	
	@PostMapping("/update_contact")
	public String mergePatientContact(
			@ModelAttribute("updateContact") Contact updateContact,
			BindingResult result,
			HttpSession session,
			Model model) {
		if (result.hasErrors()) {
			return "update_contact";
		}
		System.out.println("updateContact: " + updateContact);
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
		model.addAttribute("updateInsurance", new Insurance());
		return "update_insurance";
	}
	
	@PostMapping("/update_insurance")
	public String mergePatientInsurance(
			@ModelAttribute("updateInsurance") Insurance updateInsurance,
			BindingResult result,
			HttpSession session,
			Model model) {
		if (result.hasErrors()) {
			return "update_contact";
		}
		System.out.println("updateInsurance: " + updateInsurance);
		//call insurance service method to update insurance
		Insurance updatedInsurance = insuranceService.updateInsurance(updateInsurance);
		
		//set updatedInsurance to session attribute 'viewInsurance' for viewing on patient_details
		session.setAttribute("viewInsurance", updatedInsurance);
		return "patient_details";
	}
}
