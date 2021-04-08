
package com.simpleschedule.daniel.anderson.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleschedule.daniel.anderson.entities.Contact;
import com.simpleschedule.daniel.anderson.repositories.ContactRepository;

@Service
public class ContactService {
	private ContactRepository contactRepository;
	
	@Autowired
	ContactService(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}
	
	//SAVE NEW CONTACT
	public Contact saveNewContact(Contact contact) {
		return contactRepository.save(contact);
	}
	
	//FIND CONTACT BY cPatientId
	public Contact findContactBycPatientId(Integer cPatientId) {
		return contactRepository.findByCPatientId(cPatientId);
	}
	
	//UPDATE CONTACT
	public Contact updateContact(Contact updateContact) {
		return contactRepository.save(updateContact);
	}
	
	//DELETE CONTACT
	public void deleteContact(Contact deleteContact) {
		contactRepository.delete(deleteContact);
		System.out.println("REMOVED: " + deleteContact);
	}
}