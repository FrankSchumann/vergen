package org.vergen.preferences;

public class Constants {
	
	public static final String PREF_EDIT_SETTINGS = "editSettingsPreference";
	public static final boolean DEF_EDIT_SETTINGS = false;

	public static final String PREF_MAJOR_REGEX = "majorRegExPreference";
	public static final String DEF_MAJOR_REGEX = "FW_VERSION_MAJOR  \\= \\\\d*;";
	
	public static final String PREF_MINOR_REGEX = "minorRegExPreference";
	public static final String DEF_MINOR_REGEX = "FW_VERSION_MINOR  \\= \\\\d*;";
	
	public static final String PREF_BUGFIX_REGEX = "bugfixRegExPreference";
	public static final String DEF_BUGFIX_REGEX = "FW_VERSION_BUGFIX  \\= \\\\d*;";
	
	public static final String PREF_BUILD_REGEX = "buildRegExPreference";
	public static final String DEF_BUILD_REGEX = "FW_VERSION_BUILD  \\= \\\\d*;";
	
	public static final String PREF_TEMPLATE = "templatePreference";
	public static final String DEF_TEMPLATE = "/home/frank/git/vergen/jinja/PacConfigVersion.jinja";
	
	public static final String PREF_RESULT = "resultPreference";
	public static final String DEF_RESULT = "/home/frank/git/vergen/examples/PacConfigVersion.hpp";
}
