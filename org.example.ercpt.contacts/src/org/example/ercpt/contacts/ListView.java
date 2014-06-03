package org.example.ercpt.contacts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
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
		// Table composite (because of TableColumnLayout)
		final Composite tableComposite = new Composite(parent, SWT.NONE);
		tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true));
		final TableColumnLayout tableColumnLayout = new TableColumnLayout();
		tableComposite.setLayout(tableColumnLayout);

		// Table viewer
		tableViewer = new TableViewer(tableComposite, SWT.FULL_SELECTION);
		tableViewer.getTable().setHeaderVisible(true);

		// first name column
		final TableViewerColumn firstNameColumn = new TableViewerColumn(
				tableViewer, SWT.NONE);
		firstNameColumn.getColumn().setText("First Name");
		tableColumnLayout.setColumnData(firstNameColumn.getColumn(),
				new ColumnWeightData(40));

		// last name column
		final TableViewerColumn lastNameColumn = new TableViewerColumn(
				tableViewer, SWT.NONE);
		lastNameColumn.getColumn().setText("Last Name");
		tableColumnLayout.setColumnData(lastNameColumn.getColumn(),
				new ColumnWeightData(40));

		ObservableListContentProvider contentProvider = new ObservableListContentProvider();

		tableViewer.setContentProvider(contentProvider);

		IObservableMap[] attributes = BeansObservables.observeMaps(
				contentProvider.getKnownElements(), Contact.class,
				new String[] { "firstName", "lastName" });
		tableViewer
				.setLabelProvider(new ObservableMapLabelProvider(attributes));

		tableViewer.setInput(contacts.getAllContacts());

		GridLayoutFactory.fillDefaults().generateLayout(parent);

		tableViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						IStructuredSelection selection = (IStructuredSelection) event
								.getSelection();
						selectionService.setSelection(selection
								.getFirstElement());
					}
				});
	}
	
	
	@Focus
	public void onFocus() {
		tableViewer.getTable().setFocus();		
	}
}