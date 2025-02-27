package com.example.contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	//Store contacts in a HashMap
	private final Map<String, Contact> contacts;
	
	//Constructor
	public ContactService() {
		contacts = new HashMap<>();
	}
	
	//Add new contact
	public void addContact(Contact contact) {
		if (contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Contact ID already exists: " + contact.getContactId());
		}
		contacts.put(contact.getContactId(), contact);
	}
	
	//Delete a contact by contactId
	public void deleteContact(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID does not exist: " + contactId);
		}
		contacts.remove(contactId);
	}
	
	public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
		//Check if the contact exists
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID does not exist: " + contactId);
		}
		
		//Retrieve the contact
		Contact contact = contacts.get(contactId);
		
		//Update fields with validation
		if (firstName != null && firstName.length() <= 10) {
			contact.setFirstName(firstName);
		}
		if (lastName != null && lastName.length() <= 10) {
			contact.setLastName(lastName);
		}
		if (phone != null && phone.matches("\\d{10}")) {
			contact.setPhone(phone);
		}
		if (address != null && address.length() <= 30) {
			contact.setAddress(address);
		}
	}
	
	//getter for contacts (used for testing)
	public Map<String, Contact> getContacts() {
		return contacts;
	}

}
