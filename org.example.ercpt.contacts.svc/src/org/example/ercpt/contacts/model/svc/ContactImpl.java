package org.example.ercpt.contacts.model.svc;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.example.ercpt.contacts.model.Contact;

public class ContactImpl implements Contact {
	private String firstName;
	private String lastName;
	private String email;
	private final PropertyChangeSupport changes;

	public ContactImpl(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		changes = new PropertyChangeSupport(this);
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		changes.firePropertyChange(FIELD_FIRST_NAME, this.firstName, this.firstName = firstName);
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		changes.firePropertyChange(FIELD_LAST_NAME, this.lastName, this.lastName = lastName);
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		changes.firePropertyChange(FIELD_EMAIL, this.email, this.email = email);
	}
	
	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		changes.addPropertyChangeListener(listener);
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		changes.removePropertyChangeListener(listener);
	}

	@Override
	public String toString() {
		return "ContactImpl [firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + "]";
	}
}
