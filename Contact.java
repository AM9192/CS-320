package com.example.contact;

public class Contact {
	// Fields
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;

	// Constructor
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		// Validate and set contactId
		if (contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID: Must be non-null and 10 characters or less.");
		}
		this.contactId = contactId;

		// Validate and set firstName
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name: Must be non-null and 10 characters or less.");
		}
		this.firstName = firstName;

		// Validate and set lastName
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name: Must be non-null and 10 characters or less.");
		}
		this.lastName = lastName;

		// Validate and set phone
		if (phone == null || !phone.matches("\\d{10}")) {
			throw new IllegalArgumentException("Invalid phone number: Must be non-null and exactly 10 digits.");
		}
		this.phone = phone;

		// Validate and set address
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address: Must be non-null and 30 characters or less.");
		}
		this.address = address;
	}

	// Getters
	public String getContactId() {
		return contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	// Setters (only for fields that can be updated)
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name: Must be non-null and 10 characters or less.");
		}
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name: Must be non-null and 10 characters or less.");
		}
		this.lastName = lastName;
	}

	public void setPhone(String phone) {
		if (phone == null || !phone.matches("\\d{10}")) {
			throw new IllegalArgumentException("Invalid phone number: Must be non-null and exactly 10 digits.");
		}
		this.phone = phone;
	}

	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address: Must be non-null and 30 characters or less.");
		}
		this.address = address;
	}
}