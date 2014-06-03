package org.example.ercpt.contacts.model;

import java.beans.PropertyChangeListener;


public interface Contact {
	String FIELD_FIRST_NAME = "firstName";
	String FIELD_LAST_NAME = "lastName";
	String FIELD_EMAIL = "email";
	
	String getFirstName();

	void setFirstName(String firstName);

	String getLastName();

	void setLastName(String lastName);

	String getEmail();

	void setEmail(String email);

	void addPropertyChangeListener(PropertyChangeListener listener);

	void removePropertyChangeListener(PropertyChangeListener listener);
}
