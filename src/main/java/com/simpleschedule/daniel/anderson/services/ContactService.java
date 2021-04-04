
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
}