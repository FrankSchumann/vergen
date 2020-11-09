package org.vergen.preferences;

import org.eclipse.jface.preference.*;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.vergen.Activator;
import org.eclipse.ui.IWorkbench;

public class ParserPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private BooleanFieldEditor editSettingsBooleanFieldEditor;
	private StringFieldEditor majorStringFieldEditor;
	private StringFieldEditor minorStringFieldEditor;
	private StringFieldEditor bugfixStringFieldEditor;
	private StringFieldEditor buildStringFieldEditor;

	public ParserPage() {
		super(GRID);
		setTitle(Messages.parserTitle);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription(Messages.parserDescription);
	}

	public void createFieldEditors() {
		editSettingsBooleanFieldEditor = new BooleanFieldEditor(Constants.PREF_EDIT_SETTINGS,
				Messages.editSettingsLabelText, BooleanFieldEditor.DEFAULT, getFieldEditorParent()) {

			@Override
			protected void valueChanged(boolean oldValue, boolean newValue) {
				super.valueChanged(oldValue, newValue);
				setEnabledStringFieldEditors(newValue);
			}
		};
		addField(editSettingsBooleanFieldEditor);

		majorStringFieldEditor = new StringFieldEditor(Constants.PREF_MAJOR_REGEX, Messages.majorLabelText, -1,
				StringFieldEditor.VALIDATE_ON_KEY_STROKE, getFieldEditorParent());
		majorStringFieldEditor.setEmptyStringAllowed(false);
		majorStringFieldEditor.setEnabled(false, this.getFieldEditorParent());
		addField(majorStringFieldEditor);

		minorStringFieldEditor = new StringFieldEditor(Constants.PREF_MINOR_REGEX, Messages.minorLabelText, -1,
				StringFieldEditor.VALIDATE_ON_KEY_STROKE, getFieldEditorParent());
		minorStringFieldEditor.setEmptyStringAllowed(false);
		minorStringFieldEditor.setEnabled(false, this.getFieldEditorParent());
		addField(minorStringFieldEditor);

		bugfixStringFieldEditor = new StringFieldEditor(Constants.PREF_BUGFIX_REGEX, Messages.bugfixLabelText, -1,
				StringFieldEditor.VALIDATE_ON_KEY_STROKE, getFieldEditorParent());
		bugfixStringFieldEditor.setEmptyStringAllowed(false);
		bugfixStringFieldEditor.setEnabled(false, this.getFieldEditorParent());
		addField(bugfixStringFieldEditor);

		buildStringFieldEditor = new StringFieldEditor(Constants.PREF_BUILD_REGEX, Messages.buildLabelText, -1,
				StringFieldEditor.VALIDATE_ON_KEY_STROKE, getFieldEditorParent());
		buildStringFieldEditor.setEmptyStringAllowed(false);
		buildStringFieldEditor.setEnabled(false, this.getFieldEditorParent());
		addField(buildStringFieldEditor);

		org.vergen.preferences.Preferences preferences = new Preferences();
		boolean editSettingsPreference = preferences.getEditSettingsPreference();
		setEnabledStringFieldEditors(editSettingsPreference);
	}

	public void init(IWorkbench workbench) {
	}

	protected void performDefaults() {
		editSettingsBooleanFieldEditor.loadDefault();
		setEnabledStringFieldEditors(false);
		super.performDefaults();
	}

	private void setEnabledStringFieldEditors(boolean enabled) {
		majorStringFieldEditor.setEnabled(enabled, this.getFieldEditorParent());
		minorStringFieldEditor.setEnabled(enabled, this.getFieldEditorParent());
		bugfixStringFieldEditor.setEnabled(enabled, this.getFieldEditorParent());
		buildStringFieldEditor.setEnabled(enabled, this.getFieldEditorParent());
	}
}
