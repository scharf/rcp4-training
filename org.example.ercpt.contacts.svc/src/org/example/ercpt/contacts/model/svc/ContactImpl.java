package org.example.ercpt.contacts.model.svc;

import org.example.ercpt.contacts.model.Contact;

public class ContactImpl implements Contact {
	private String firstName;
	private String lastName;
	private String email;

	public ContactImpl(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ContactImpl [firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + "]";
	}
}
