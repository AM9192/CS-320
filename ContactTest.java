package com.example.contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {
    
    @Test
    void testValidContactCreation() {
        Contact contact = new Contact("12345", "Miles", "Morales", "1234567890", "234 Main St");
        
        assertEquals("12345", contact.getContactId());
        assertEquals("Miles", contact.getFirstName());
        assertEquals("Morales", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("234 Main St", contact.getAddress());
    }
    
    @Test
    void testInvalidContactId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Miles", "Morales", "1234567890","234 Main St");
        });
        assertEquals("Invalid contact ID: Must be non-null and 10 characters or less.", exception.getMessage());
        
        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("55555555555", "Miles", "Morales", "1234567890", "234 Main St");
        });
        assertEquals("Invalid contact ID: Must be non-null and 10 characters or less.", exception.getMessage());
    }
    
    @Test
    void testInvalidFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "MilesMoraless", "Morales", "1234567890", "234 Main St.");
        });
        assertEquals("Invalid first name: Must be non-null and 10 characters or less.", exception.getMessage());
    }
    
    @Test
    void testInvalidLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Miles", null, "1234567890", "234 Main St");
        });
        assertEquals("Invalid last name: Must be non-null and 10 characters or less.", exception.getMessage());
        
        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Miles", "MoralesMorales", "1234567890", "234 Main St");
        });
        assertEquals("Invalid last name: Must be non-null and 10 characters or less.", exception.getMessage());
    }
    
    @Test
    void testInvalidPhone() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Miles", "Morales", null, "234 Main St");
        });
        assertEquals("Invalid phone number: Must be non-null and exactly 10 digits.", exception.getMessage());
    }
    
    @Test
    void testInvalidPhoneNumberLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Miles", "Morales", "12345", "234 Main St");
        });
        assertEquals("Invalid phone number: Must be non-null and exactly 10 digits.", exception.getMessage());
    }

    @Test
    void testInvalidAddress() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Miles", "Morales", "1234567890", null);
        });
        assertEquals("Invalid address: Must be non-null and 30 characters or less.", exception.getMessage());
    }
    
    @Test
    void testSetter() {
        Contact contact = new Contact("12345", "Miles", "Morales", "1234567890", "234 Main St");
        
        contact.setFirstName("Gwen");
        assertEquals("Gwen", contact.getFirstName());
        
        contact.setLastName("Stacy");
        assertEquals("Stacy", contact.getLastName());
        
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
        
        contact.setAddress("555 Harrison St");
        assertEquals("555 Harrison St", contact.getAddress());
    }
    
    @Test
    void testInvalidSetter() {
        Contact contact = new Contact("12345", "Miles", "Morales", "1234567890", "234 Main St");
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("MilesMoraless");
        });
        assertEquals("Invalid first name: Must be non-null and 10 characters or less.", exception.getMessage());
        
        exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("MoralesMorales");
        });
        assertEquals("Invalid last name: Must be non-null and 10 characters or less.", exception.getMessage());
        
        exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("12345");
        });
        assertEquals("Invalid phone number: Must be non-null and exactly 10 digits.", exception.getMessage());
        
        exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("This is a very long address that exceeds the 30 character limit.");
        });
        assertEquals("Invalid address: Must be non-null and 30 characters or less.", exception.getMessage());
    }
}