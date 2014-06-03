package org.example.ercpt.contacts.model.svc;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.example.ercpt.contacts.model.Contact;
import org.example.ercpt.contacts.model.ContactsRepository;

public class ContactRepositoryImpl implements ContactsRepository {
	private final IObservableList contacts;
	
	public ContactRepositoryImpl() {
		List<Contact> contactList = new ArrayList<Contact>();
		contactList.add(new ContactImpl("Michael", "Scharf", "michael.rcp@scharf.gr"));
		contactList.add(new ContactImpl("Kai", "Toedter", "kai@toedter.com"));
		contactList.add(new ContactImpl("Tom", "Schindl", "tom.schindl@bestsolution.at"));
		contactList.add(new ContactImpl("Lars", "Vogel", "lars.vogel@googlemail.com"));
		contacts = new WritableList(contactList, null);
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
	public IObservableList getAllContactsObservable() {
		return contacts;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getAllContacts() {
		return contacts;
	}

}
