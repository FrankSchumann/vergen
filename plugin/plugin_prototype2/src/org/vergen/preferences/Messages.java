package org.vergen.preferences;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.vergen.preferences.messages"; //$NON-NLS-1$
	
	public static String vergenTitle;
	public static String vergenDescription;
	
	public static String templateLabelText;
	public static String resultLabelText;
	
	public static String parserTitle;
	public static String parserDescription;
	
	public static String editSettingsLabelText;
	public static String majorLabelText;
	public static String minorLabelText;
	public static String bugfixLabelText;
	public static String buildLabelText;

	////////////////////////////////////////////////////////////////////////////
	//
	// Constructor
	//
	////////////////////////////////////////////////////////////////////////////
	private Messages() {
		// do not instantiate
	}

	////////////////////////////////////////////////////////////////////////////
	//
	// Class initialization
	//
	////////////////////////////////////////////////////////////////////////////
	static {
		// load message values from bundle file
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
