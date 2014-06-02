package org.example.ercpt.contacts.model;

import java.util.List;

public interface ContactsRepository {

	List<Contact> getAllContacts();

	void addContact(Contact contact);

	void removeContact(Contact contact);
}
