package org.example.ercpt.contacts.model.svc;

import java.util.ArrayList;
import java.util.List;

import org.example.ercpt.contacts.model.Contact;
import org.example.ercpt.contacts.model.ContactsRepository;

public class ContactRepositoryImpl implements ContactsRepository {
	private final List<Contact> contacts;
	
	public ContactRepositoryImpl() {
		contacts = new ArrayList<Contact>();
		contacts.add(new ContactImpl("Michael", "Scharf", "michael.rcp@scharf.gr"));
		contacts.add(new ContactImpl("Kai", "Toedter", "kai@toedter.com"));
		contacts.add(new ContactImpl("Tom", "Schindl", "tom.schindl@bestsolution.at"));
		contacts.add(new ContactImpl("Lars", "Vogel", "lars.vogel@googlemail.com"));
	}

	@Override
	public void addContact(final Contact contact) {
		contacts.add(contact);
	}

	@Override
	public void removeContact(final Contact contact) {
		contacts.remove(contact);
	}

	@Override
	public List<Contact> getAllContacts() {
		return contacts;
	}

}
