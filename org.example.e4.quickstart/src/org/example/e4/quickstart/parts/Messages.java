package org.example.e4.quickstart.parts;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.example.e4.quickstart.parts.messages"; //$NON-NLS-1$
	public static String SamplePart_0;
	public static String SamplePart_1;
	public static String SamplePart_2;
	public static String SamplePart_3;
	public static String SamplePart_4;
	public static String SamplePart_5;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
