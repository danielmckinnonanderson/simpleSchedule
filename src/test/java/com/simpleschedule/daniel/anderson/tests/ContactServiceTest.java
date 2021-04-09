package com.simpleschedule.daniel.anderson.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.simpleschedule.daniel.anderson.entities.Contact;
import com.simpleschedule.daniel.anderson.repositories.ContactRepository;
import com.simpleschedule.daniel.anderson.services.ContactService;


class ContactServiceTest {
	private static ContactRepository contactRepository;
	private static ContactService contactService;
	
	@BeforeAll
	static void setup() {
		contactRepository = Mockito.mock(ContactRepository.class);
		contactService = new ContactService(contactRepository);
	}
	
	@Test
	void testSaveNewContact() {
		Contact testContact = new Contact(1, 5551110000L, null, null, "test@email.com");
		
		Mockito.when(contactRepository.save(testContact)).thenReturn(testContact);
		
		Contact actual = contactService.saveNewContact(testContact);
		Contact expected = new Contact(1, 5551110000L, null, null, "test@email.com");
		assertEquals(expected, actual);
	}
	
	@Test
	void testFindContactByCPatientId() {
		Contact testContact = new Contact(1, 5551110000L, null, null, "test@email.com");
		
		Mockito.when(contactRepository.findByCPatientId(1)).thenReturn(testContact);
		
		Contact actual = contactService.findContactBycPatientId(1);
		Contact expected = new Contact(1, 5551110000L, null, null, "test@email.com");
		assertEquals(expected, actual);
	}
	
	@Test
	void testUpdateContact() {
		Contact savedContact = new Contact(1, 5551110000L, null, null, "test@email.com");
		Contact updateContact = new Contact(1, 888111000L, 9991110000L, null, "updateemail@gmail.com");
		
		Mockito.when(contactRepository.save(updateContact)).thenReturn(updateContact);
		
		
		Contact actual = contactService.updateContact(updateContact);
		Contact expected = new Contact(1, 888111000L, 9991110000L, null, "updateemail@gmail.com");
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testDeleteContact() {
		Contact notSavedContact = new Contact(1, 5551110000L, null, null, "test@email.com");
		
		Mockito.doNothing().when(contactRepository).delete(notSavedContact);
		
		boolean actual = contactService.deleteContact(notSavedContact);
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
}
