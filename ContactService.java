package com.snhu.kc.contactservice;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	
	// in-memory data structure to store contacts
	private final Map<String, Contact> contacts = new HashMap<>();

	// adding a new contact to the in-memory storage
	public void add(Contact contact) {
		if (contact == null) {
			throw new IllegalArgumentException("Contact is null.");
		}
		if (contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Please enter a unique contact.");
		}
		contacts.put(contact.getContactId(), contact);
	}

	// updating a contact that has been added before
	public void update(String contactId, String firstName, String lastName, String phone, String address) {
		Contact contact = contacts.get(contactId);
		if (contact == null) {
			throw new IllegalArgumentException("Please enter a valid contact to update.");
		}
		if (firstName != null) {
			contact.setFirstName(firstName);
		}
		if (lastName != null) {
			contact.setLastName(lastName);
		}
		if (phone != null) {
			contact.setPhone(phone);
		}
		if (address != null) {
			contact.setAddress(address);
		}
	}

	// deleting a contact that has been added before
	public void delete(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Enter a valid contact to delete.");
		}
		contacts.remove(contactId);
	}

	// Method to get a contact by contact id
	public Contact getContact(String contactId) {
		return contacts.get(contactId);
	}
}
