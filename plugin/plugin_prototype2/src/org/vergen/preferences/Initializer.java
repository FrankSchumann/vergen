package org.vergen.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.vergen.Activator;

public class Initializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		
		store.setDefault(Constants.PREF_TEMPLATE, Constants.DEF_TEMPLATE);
		store.setDefault(Constants.PREF_RESULT, Constants.DEF_RESULT);
		
		store.setDefault(Constants.PREF_MAJOR_REGEX, Constants.DEF_MAJOR_REGEX);
		store.setDefault(Constants.PREF_MINOR_REGEX, Constants.DEF_MINOR_REGEX);
		store.setDefault(Constants.PREF_BUGFIX_REGEX, Constants.DEF_BUGFIX_REGEX);
		store.setDefault(Constants.PREF_BUILD_REGEX, Constants.DEF_BUILD_REGEX);
	}

}
