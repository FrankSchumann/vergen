package org.vergen.views.commands;

import org.eclipse.swt.widgets.Composite;
import org.vergen.views.Version;
import org.vergen.views.Widgets;
import org.eclipse.jface.dialogs.MessageDialog;

public class Receiver {

	private Widgets widgets;
	private Composite parent;

	public Receiver(Widgets widgets, Composite parent) {
		this.widgets = widgets;
		this.parent = parent;
	}

	public void updateView() {
		Version version = widgets.getVersion();
		
		widgets.setVersion(version);
	}

	public void refresh() {
		// TODO get version from parser

		Version version = new Version(1, 64, 23, 5);

		widgets.setVersion(version);
	}

	public void generate() {
		Version version = widgets.getVersion();

		// TODO add generator

		String result = "PacConfigVersion.hpp";
		String versionTmp = version.toString();
		String message = "File " + result + " generated with version " + versionTmp;

		showMessage(parent, message);
	};

	private void showMessage(Composite parent, String message) {
		MessageDialog.openInformation(parent.getShell(), "VerGen View", message);
	}

}
