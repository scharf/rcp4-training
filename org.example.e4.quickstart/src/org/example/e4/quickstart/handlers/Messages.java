package org.example.e4.quickstart.handlers;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.example.e4.quickstart.handlers.messages"; //$NON-NLS-1$
	public static String AboutHandler_0;
	public static String AboutHandler_1;
	public static String QuitHandler_0;
	public static String QuitHandler_1;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
