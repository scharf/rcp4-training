package org.example.ercpt.contacts;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class ListView {
	private TableViewer tableViewer;
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		tableViewer = new TableViewer(parent);
		tableViewer.add("Michael Scharf");
		tableViewer.add("Kai Tödter");
		tableViewer.add("Lars Vogel");
		tableViewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
	}
	
	
	@Focus
	public void onFocus() {
		tableViewer.getTable().setFocus();		
	}
}