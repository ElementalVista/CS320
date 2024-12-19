package org.example;

//Made by Christopher Rossi


public class Contact {
    private final String contactId;  // Unique identifier for the contact
    private String firstName;        // First name of the contact
    private String lastName;         // Last name of the contact
    private String phone;            // Phone number of the contact
    private String address;          // Address of the contact

    // Constructor
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Validate input
        if (contactId == null || contactId.length() > 10 || firstName == null || firstName.length() > 10 ||
                lastName == null || lastName.length() > 10 || phone == null || phone.length() != 10 ||
                address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid input");  // Throw exception if any fails
        }
        this.contactId = contactId;  // Set the contactId
        this.firstName = firstName;  // Set the first name
        this.lastName = lastName;    // Set the last name
        this.phone = phone;          // Set the phone number
        this.address = address;      // Set the address
    }

    // Getter for contactId
    public String getContactId() {
        return contactId;
    }

    // Getter for firstName
    public String getFirstName() {
        return firstName;
    }

    // Setter for firstName with validation
    public void setFirstName(String firstName) {
        // Check if the first name is not null and its length is less than or equal to 10 characters
        if (firstName != null && firstName.length() <= 10) {
            this.firstName = firstName;  // Set the first name if valid
        }
    }

    // Getter for lastName
    public String getLastName() {
        return lastName;
    }

    // Setter
    public void setLastName(String lastName) {
        // Check if the last name is not null and its length is less than or equal to 10 characters
        if (lastName != null && lastName.length() <= 10) {
            this.lastName = lastName;  // Set the last name if valid
        }
    }

    // Getter for phone
    public String getPhone() {
        return phone;
    }

    // Setter
    public void setPhone(String phone) {
        // Check if the phone is not null and its length is exactly 10 characters
        if (phone != null && phone.length() == 10) {
            this.phone = phone;  // Set the phone number if valid
        }
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter
    public void setAddress(String address) {
        // Check if the address is not null and its length is less than or equal to 30 characters
        if (address != null && address.length() <= 30) {
            this.address = address;  // Set the address if valid
        }
    }
}