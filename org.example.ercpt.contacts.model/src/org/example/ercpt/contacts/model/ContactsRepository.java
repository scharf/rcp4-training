package org.example.ercpt.contacts.model;

import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;

public interface ContactsRepository {
	List<Contact> getAllContacts();

	IObservableList getAllContactsObservable();

	void addContact(Contact contact);

	void removeContact(Contact contact);
}
