package com.example.contact;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    
    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "Miles", "Morales", "1234567890", "234 Main St");
        
        // Add contact
        service.addContact(contact);
        
        // Verify the contact is added
        assertEquals(contact, service.getContacts().get("1"));
    }

    @Test
    public void testAddDuplicateContactId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("1", "Miles", "Morales", "1234567890", "234 Main St");
        Contact contact2 = new Contact("1", "Gwen", "Stacy", "0987654321", "555 Harrison St");
        
        service.addContact(contact1);
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
        assertEquals("Contact ID already exists: 1", exception.getMessage());
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "Miles", "Morales", "1234567890", "234 Main St");
        
        // Add a contact first
        service.addContact(contact);
        
        // Delete the contact
        service.deleteContact("1");
        
        // Verify the contact has been deleted
        assertFalse(service.getContacts().containsKey("1"));
    }

    @Test
    public void testDeleteNonExistentContact() {
        ContactService service = new ContactService();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("999");
        });
        assertEquals("Contact ID does not exist: 999", exception.getMessage());
    }

    @Test
    public void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "Miles", "Morales", "1234567890", "234 Main St");
        
        // Add a contact first
        service.addContact(contact);
        
        // Update the contact
        service.updateContact("1", "Gwen", "Stacy", "0987654321", "555 Harrison St");
        
        // Verify the updated fields
        Contact updatedContact = service.getContacts().get("1");
        assertEquals("Gwen", updatedContact.getFirstName());
        assertEquals("Stacy", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("555 Harrison St", updatedContact.getAddress());
    }

    @Test
    public void testUpdateNonExistentContact() {
        ContactService service = new ContactService();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("999", "Gwen", "Stacy", "0987654321", "555 Harrison St");
        });
        assertEquals("Contact ID does not exist: 999", exception.getMessage());
    }
}
