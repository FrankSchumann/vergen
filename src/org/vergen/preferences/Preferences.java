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
	
}
