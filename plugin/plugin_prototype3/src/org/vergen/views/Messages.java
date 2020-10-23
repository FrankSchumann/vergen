package org.vergen.views;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.vergen.views.messages"; //$NON-NLS-1$

	public static String vergenTitle;

	public static String versionLabel;
	public static String versionValue;

	public static String majorLabel;
	public static String minorLabel;
	public static String bugfixLabel;
	public static String buildLabel;
	public static String fileLocationLabel;

	public static String refreshButton;
	public static String generateButton;

	public static String RefreshActionImageUrl;
	public static String refreshActionText;
	public static String refreshActionToolTip;

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
