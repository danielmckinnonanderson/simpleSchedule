
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
		if (contact != null) {
			return contactRepository.save(contact);
		} else {
			return null;
		}
	}
	
	//FIND CONTACT BY cPatientId
	public Contact findContactBycPatientId(Integer cPatientId) {
		if (cPatientId != null) {
			Contact foundContact = contactRepository.findByCPatientId(cPatientId);
			if (foundContact != null) {
				return foundContact;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	//UPDATE CONTACT
	public Contact updateContact(Contact updateContact) {
		if (updateContact != null) {
			if (contactRepository.findByCPatientId(updateContact.getcPatientId()) != null) {
				return contactRepository.save(updateContact);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	//DELETE CONTACT
	public boolean deleteContact(Contact deleteContact) {
		if (deleteContact != null) {
			if (contactRepository.findByCPatientId(deleteContact.getcPatientId()) != null) {
				contactRepository.delete(deleteContact);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}