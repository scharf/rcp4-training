package org.example.ercpt.contacts.views.details;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.example.ercpt.contacts.model.Contact;

public class DetailsView {
	private DataBindingContext dbc;
	private WritableValue contactValue;
	private Text firstName;
	private Text lastName;
	private Label lblEmail;
	private Text email;

	@Inject
	public DetailsView() {
		
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new GridLayout(2, false));
		Realm.runWithDefault(SWTObservables.getRealm(Display.getDefault()),
				new Runnable() {

					@Override
					public void run() {
						dbc = new DataBindingContext();
						contactValue = new WritableValue();
					}
				});
		
		Label nameLabel = new Label(parent, SWT.NONE);
		nameLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		nameLabel.setText("First Name");
		firstName = new Text(parent, SWT.BORDER);
		firstName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		dbc.bindValue(SWTObservables.observeText(firstName, SWT.Modify),
				PojoObservables.observeDetailValue(contactValue, Contact.FIELD_FIRST_NAME,
						String.class));
		
		
		Label lblLastName = new Label(parent, SWT.NONE);
		lblLastName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLastName.setText("Last Name");
		lastName = new Text(parent, SWT.BORDER);
		lastName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		dbc.bindValue(SWTObservables.observeText(lastName, SWT.Modify),
				PojoObservables.observeDetailValue(contactValue, Contact.FIELD_LAST_NAME,
						String.class));
		
		
		lblEmail = new Label(parent, SWT.NONE);
		lblEmail.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblEmail.setText("Email");
		
		email = new Text(parent, SWT.BORDER);
		email.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		dbc.bindValue(SWTObservables.observeText(email, SWT.Modify),
				PojoObservables.observeDetailValue(contactValue, Contact.FIELD_EMAIL,
						String.class));
	}

	@Inject
	public void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) Contact contact) {
		if(firstName==null || firstName.isDisposed())
			return;
		if (contact != null) {
			contactValue.setValue(contact);
		}
	}
}