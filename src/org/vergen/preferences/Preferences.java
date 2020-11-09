package org.vergen.preferences;

import org.eclipse.core.runtime.preferences.InstanceScope;

public class Preferences {
	
	private org.osgi.service.prefs.Preferences osgiPreferences = null;
	
	public Preferences() {
		osgiPreferences = InstanceScope.INSTANCE.getNode("org.vergen");
	}
	
	public String getTemplateFilename() {
		String templateFilename = osgiPreferences.get(Constants.PREF_TEMPLATE, Constants.DEF_TEMPLATE);
		return templateFilename;
	}

	public String getResultFilename() {
		String resultFilename = osgiPreferences.get(Constants.PREF_RESULT, Constants.DEF_RESULT);
		return resultFilename;
	}
	
	public String getMajorRegex() {
		String majorRegex = osgiPreferences.get(Constants.PREF_MAJOR_REGEX, Constants.DEF_MAJOR_REGEX);
		return majorRegex;
	}
	
	public String getMinorRegex() {
		String minorRegex = osgiPreferences.get(Constants.PREF_MINOR_REGEX, Constants.DEF_MINOR_REGEX);
		return minorRegex;
	}
	
	public String getBugfixRegex() {
		String bugfixRegex = osgiPreferences.get(Constants.PREF_BUGFIX_REGEX, Constants.DEF_BUGFIX_REGEX);
		return bugfixRegex;
	}
	
	public String getBuildRegex() {
		String buildRegex = osgiPreferences.get(Constants.PREF_BUILD_REGEX, Constants.DEF_BUILD_REGEX);
		return buildRegex;
	}
	
}
