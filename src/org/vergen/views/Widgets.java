package org.vergen.views;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.vergen.core.Version;

public class Widgets {

	private Label versionValueLabel;
	private Spinner majorSpinner;
	private Spinner minorSpinner;
	private Spinner bugfixSpinner;
	private Spinner buildSpinner;
	
	public Label getVersionValueLabel() {
		return versionValueLabel;
	}
	public void setVersionValueLabel(Label versionValueLabel) {
		this.versionValueLabel = versionValueLabel;
	}
	public Spinner getMajorSpinner() {
		return majorSpinner;
	}
	public void setMajorSpinner(Spinner majorSpinner) {
		this.majorSpinner = majorSpinner;
	}
	public Spinner getMinorSpinner() {
		return minorSpinner;
	}
	public void setMinorSpinner(Spinner minorSpinner) {
		this.minorSpinner = minorSpinner;
	}
	public Spinner getBugfixSpinner() {
		return bugfixSpinner;
	}
	public void setBugfixSpinner(Spinner bugfixSpinner) {
		this.bugfixSpinner = bugfixSpinner;
	}
	public Spinner getBuildSpinner() {
		return buildSpinner;
	}
	public void setBuildSpinner(Spinner buildSpinner) {
		this.buildSpinner = buildSpinner;
	}
	
	public String getMajor() {
		return Integer.toString(majorSpinner.getSelection());
	}
	
	public String getMinor() {
		return Integer.toString(minorSpinner.getSelection());
	}
	
	public String getBugfix() {
		return Integer.toString(bugfixSpinner.getSelection());
	}
	
	public String getBuild() {
		return Integer.toString(buildSpinner.getSelection());
	}
	
	public void setVersion(Version version) {
		versionValueLabel.setText(version.toString());
		
		majorSpinner.setSelection(version.getMajor());
		minorSpinner.setSelection(version.getMinor());
		bugfixSpinner.setSelection(version.getBugfix());
		buildSpinner.setSelection(version.getBuild());
	}
	
	public Version getVersion() {
		int major = majorSpinner.getSelection();
		int minor = minorSpinner.getSelection();
		int bugfix = bugfixSpinner.getSelection();
		int build = buildSpinner.getSelection();
		
		return new Version(major, minor, bugfix, build);
	}
}
