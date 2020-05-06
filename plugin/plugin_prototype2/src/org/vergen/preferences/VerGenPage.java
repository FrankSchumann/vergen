package org.vergen.preferences;

import org.eclipse.jface.preference.*;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.vergen.Activator;
import org.eclipse.ui.IWorkbench;

public class VerGenPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public VerGenPage() {
		super(GRID);
		setTitle(Messages.vergenTitle);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription(Messages.vergenDescription);
	}

	public void createFieldEditors() {
		{
			FileFieldEditor TemplateFileFieldEditor = new FileFieldEditor(Constants.PREF_TEMPLATE, Messages.templateLabelText, getFieldEditorParent());
			TemplateFileFieldEditor.setEmptyStringAllowed(false);
			addField(TemplateFileFieldEditor);
		}
		{
			FileFieldEditor ResultFileFieldEditor = new FileFieldEditor(Constants.PREF_RESULT, Messages.resultLabelText, getFieldEditorParent());
			ResultFileFieldEditor.setEmptyStringAllowed(false);
			addField(ResultFileFieldEditor);
		}
	}

	public void init(IWorkbench workbench) {
	}

}