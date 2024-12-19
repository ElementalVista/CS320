package org.example;

// Made by Christopher Rossi

import junit.framework.TestCase;

public class ContactTest extends TestCase {

    public void testValidContact() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("123", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("123 Main St", contact.getAddress());
    }

    public void testInvalidContact() {
        // Test null contactId
        try {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        // Test too long contactId
        try {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        // Test null first name
        try {
            new Contact("123", null, "Doe", "1234567890", "123 Main St");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        // Test null last name
        try {
            new Contact("123", "John", null, "1234567890", "123 Main St");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        // Test null phone number
        try {
            new Contact("123", "John", "Doe", null, "123 Main St");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        // Test invalid phone number length
        try {
            new Contact("123", "John", "Doe", "12345", "123 Main St");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        // Test null address
        try {
            new Contact("123", "John", "Doe", "1234567890", null);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        // Test too long address
        try {
            new Contact("123", "John", "Doe", "1234567890", "123 Main St 123 Main St 123 Main St 123 Main St 123 Main St");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }
}