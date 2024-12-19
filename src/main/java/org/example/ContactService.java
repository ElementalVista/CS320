package org.example;

//Made by Christopher Rossi

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // A Map to store contacts using their contactId as the key
    private final Map<String, Contact> contacts = new HashMap<>();

    // Method
    public boolean addContact(Contact contact) {
        // Check if the contact ID already exists
        if (contacts.containsKey(contact.getContactId())) {
            return false;  // Return false if the contact ID is a duplicate
        }
        // Add the contact to the Map using its contactId as the key
        contacts.put(contact.getContactId(), contact);
        return true;  // Return true if the contact was successfully added
    }

    // Method
    public boolean deleteContact(String contactId) {
        // Remove the contact from the Map and return true if it was found and removed
        return contacts.remove(contactId) != null;
    }

    // Method
    public boolean updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        // Retrieve the contact by its contactId
        Contact contact = contacts.get(contactId);
        // If the contact exists, update its details
        if (contact != null) {
            contact.setFirstName(firstName);
            contact.setLastName(lastName);
            contact.setPhone(phone);
            contact.setAddress(address);
            return true;  // Return true if the update was successful
        }
        return false;  // Return false if no contact was found with the given ID
    }
}