package com.snhu.kc.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.snhu.kc.contactservice.ContactService;

import com.snhu.kc.contactservice.*;

class ContactServiceTests {

	private ContactService service;

	@BeforeEach
	public void setUp() {
		service = new ContactService();
	}

	@Test
	public void Given_Contact_When_Valid_Then_AddContact_Success() {
		Contact contact = new Contact("1", "Kemal", "C", "1234567890", "Dummy Address");
		service.add(contact);
		Assertions.assertNotNull(service.getContact("1"));
	}

	@Test
	public void Given_Contact_When_ContactId_Not_Unique_Then_AddContact_Error() {
		Contact contact1 = new Contact("1", "Kemal", "C", "1234567890", "Dummy Address");
		service.add(contact1);
		Contact contact2 = new Contact("1", "Kemal", "B", "0987654321", "453 Real St.");
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.add(contact2));
	}

	@Test
	public void Given_Contact_When_Data_is_Valid_Then_Update_Success() {
		Contact contact = new Contact("3", "Kirk", "Hammet", "7049099090", "157 Apple St");
		service.add(contact);
		service.update("3", "Kirk", "Johnson", "7046506060", "199 Art Dr");
		Contact updatedContact = service.getContact("3");
		Assertions.assertEquals("Kirk", updatedContact.getFirstName());
		Assertions.assertEquals("7046506060", updatedContact.getPhone());
	}

	@Test
	public void Given_Contact_When_Data_is_Not_Valid_Then_Update_Fail() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.update("18", "Joe", null, null, null));
	}

	@Test
	public void Given_Contact_When_Data_is_Valid_Then_DeleteContact_Success() {
		Contact contact = new Contact("2", "James", "Hetfield", "0101010101", "111 Metallica St.");
		service.add(contact);
		service.delete("2");
		Assertions.assertNull(service.getContact("2"));
	}

	@Test
	public void Given_Contact_When_Data_is__Not_Valid_Then_DeleteContact_Fail() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.delete("99"));
	}
}
