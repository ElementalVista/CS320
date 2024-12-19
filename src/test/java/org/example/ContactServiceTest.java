package org.example;

//Made by Christopher Rossi

import junit.framework.TestCase;

public class ContactServiceTest extends TestCase {

    // Test case for adding a contact
    public void testAddContact() {
        ContactService service = new ContactService();  // Create a new ContactService instance
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St"); // Create a new contact
        assertTrue(service.addContact(contact));  // Assert that adding the contact is successful
        assertFalse(service.addContact(contact)); // Assert that adding the same contact again fails (duplicate contact ID)
    }

    // Test case for deleting a contact
    public void testDeleteContact() {
        ContactService service = new ContactService();  // Create a new ContactService instance
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St"); // Create a new contact
        service.addContact(contact);  // Add the contact to the service
        assertTrue(service.deleteContact("123"));  //Deleting the contact by ID is successful
        assertFalse(service.deleteContact("123")); // Deleting the same contact again fails (already deleted)
    }

    // Test case for updating a contact
    public void testUpdateContact() {
        ContactService service = new ContactService();  // Create a new ContactService instance
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St"); // Create a new contact
        service.addContact(contact);  // Add the contact to the service
        // Updating the contact's first name and phone is successful
        assertTrue(service.updateContact("123", "Jane", null, "0987654321", "456 Elm St"));
        assertEquals("Jane", contact.getFirstName());  // Verify that the first name was updated
        assertEquals("0987654321", contact.getPhone()); // Verify that the phone number was updated
    }
}