package org.example.ercpt.contacts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.example.ercpt.contacts.model.Contact;
import org.example.ercpt.contacts.model.ContactsRepository;

public class ListView {
	private TableViewer tableViewer;
	@Inject
	private ESelectionService selectionService;
	@PostConstruct
	public void postConstruct(Composite parent, ContactsRepository contacts) {
		parent.setLayout(new GridLayout(1, false));
		tableViewer = new TableViewer(parent);
		for(Contact contact :contacts.getAllContacts()) {
			tableViewer.add(contact.getFirstName()+ " " + contact.getLastName());
			
		}
		tableViewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
		tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				selectionService.setSelection(selection.getFirstElement());
			}
		});
	}
	
	
	@Focus
	public void onFocus() {
		tableViewer.getTable().setFocus();		
	}
}