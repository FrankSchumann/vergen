package org.vergen.views.factories;

import org.eclipse.swt.widgets.Spinner;
import org.vergen.views.Messages;
import org.vergen.views.Widgets;
import org.vergen.views.builders.ButtonBuilder;
import org.vergen.views.builders.LabelBuilder;
import org.vergen.views.builders.SpinnerBuilder;
import org.vergen.views.commands.Command;
import org.vergen.views.commands.GenerateCommand;
import org.vergen.views.commands.Invoker;
import org.vergen.views.commands.Receiver;
import org.vergen.views.commands.RefreshCommand;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;

public final class WidgetsFactory {

	/**
	 * Labels
	 */

	public static void createLabelVersionText(Composite parent) {
		new LabelBuilder(parent).setText(Messages.versionLabel).setBounds(20, 5, 51, 19).build();
	}

	public static void createLabelVersionValue(Composite parent, Widgets widgets) {
		Label label = new LabelBuilder(parent).setText(Messages.versionValue).setBounds(108, 5, 75, 19).setStyle(SWT.BOLD).build();
		widgets.setVersionValueLabel(label);
	}

	public static void createSeparator(Composite parent) {
		Label separator = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setBounds(5, 27, 230, 10);
	}

	public static Label createLabelMajor(Composite parent) {
		Label label = new LabelBuilder(parent).setText(Messages.majorLabel).setBounds(24, 52, 70, 19).build();
		return label;
	}

	public static void createLabelMinor(Composite parent) {
		new LabelBuilder(parent).setText(Messages.minorLabel).setBounds(24, 92, 70, 19).build();
	}

	public static void createLabelBugfix(Composite parent) {
		new LabelBuilder(parent).setText(Messages.bugfixLabel).setBounds(24, 136, 70, 19).build();
	}

	public static void createLabelBuild(Composite parent) {
		new LabelBuilder(parent).setText(Messages.buildLabel).setBounds(24, 172, 70, 19).build();
	}

	/**
	 * Spinners
	 */

	public static void createSpinnerMajor(Composite parent, Widgets widgets, Invoker invoker) {
		Spinner spinner = new SpinnerBuilder(parent).setWidgets(widgets).setInvoker(invoker).setBounds(108, 46, 70, 25)
				.build();
		widgets.setMajorSpinner(spinner);
	}

	public static void createSpinnerMinor(Composite parent, Widgets widgets, Invoker invoker) {
		Spinner spinner = new SpinnerBuilder(parent).setWidgets(widgets).setInvoker(invoker).setBounds(108, 86, 70, 25)
				.build();
		widgets.setMinorSpinner(spinner);
	}

	public static void createSpinnerBugfix(Composite parent, Widgets widgets, Invoker invoker) {
		Spinner spinner = new SpinnerBuilder(parent).setWidgets(widgets).setInvoker(invoker)
				.setBounds(108, 126, 70, 25).build();
		widgets.setBugfixSpinner(spinner);
	}

	public static void createSpinnerBuild(Composite parent, Widgets widgets, Invoker invoker) {
		Spinner spinner = new SpinnerBuilder(parent).setWidgets(widgets).setInvoker(invoker)
				.setBounds(108, 166, 70, 25).build();
		widgets.setBuildSpinner(spinner);
	}

	/**
	 * Buttons
	 */

	public static void createButtonRefresh(Composite parent, Widgets widgets, Invoker invoker) {
		Command command = new RefreshCommand(new Receiver(widgets, parent));

		new ButtonBuilder(parent).setWidgets(widgets).setInvoker(invoker).setCommand(command).setBounds(24, 210, 70, 25)
				.setText(Messages.refreshButton).build();
	}

	public static void createButtonGenerate(Composite parent, Widgets widgets, Invoker invoker) {
		Command command = new GenerateCommand(new Receiver(widgets, parent));

		new ButtonBuilder(parent).setWidgets(widgets).setInvoker(invoker).setCommand(command)
				.setBounds(108, 210, 70, 25).setText(Messages.generateButton).build();
	}
}
