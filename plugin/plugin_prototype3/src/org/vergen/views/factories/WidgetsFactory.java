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
		new LabelBuilder(parent).setText(Messages.versionLabel).setBounds(34, 5, 51, 19).build();
	}

	public static void createLabelVersionValue(Composite parent, Widgets widgets) {
		Label label = new LabelBuilder(parent).setText(Messages.versionValue).setBounds(130, 5, 75, 19).setStyle(SWT.BOLD).build();
		widgets.setVersionValueLabel(label);
	}

	public static void createSeparator(Composite parent) {
		Label separator = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setBounds(5, 27, 230, 10);
	}

	public static Label createLabelMajor(Composite parent) {
		Label label = new LabelBuilder(parent).setText(Messages.majorLabel).setBounds(24, 46, 78, 27).build();
		return label;
	}

	public static void createLabelMinor(Composite parent) {
		new LabelBuilder(parent).setText(Messages.minorLabel).setBounds(24, 91, 78, 27).build();
	}

	public static void createLabelBugfix(Composite parent) {
		new LabelBuilder(parent).setText(Messages.bugfixLabel).setBounds(24, 136, 77, 27).build();
	}

	public static void createLabelBuild(Composite parent) {
		new LabelBuilder(parent).setText(Messages.buildLabel).setBounds(24, 181, 78, 27).build();
	}

	/**
	 * Spinners
	 */

	public static void createSpinnerMajor(Composite parent, Widgets widgets, Invoker invoker) {
		Spinner spinner = new SpinnerBuilder(parent).setWidgets(widgets).setInvoker(invoker).setBounds(108, 30, 108, 39)
				.build();
		widgets.setMajorSpinner(spinner);
	}

	public static void createSpinnerMinor(Composite parent, Widgets widgets, Invoker invoker) {
		Spinner spinner = new SpinnerBuilder(parent).setWidgets(widgets).setInvoker(invoker).setBounds(108, 79, 108, 39)
				.build();
		widgets.setMinorSpinner(spinner);
	}

	public static void createSpinnerBugfix(Composite parent, Widgets widgets, Invoker invoker) {
		Spinner spinner = new SpinnerBuilder(parent).setWidgets(widgets).setInvoker(invoker)
				.setBounds(108, 124, 108, 39).build();
		widgets.setBugfixSpinner(spinner);
	}

	public static void createSpinnerBuild(Composite parent, Widgets widgets, Invoker invoker) {
		Spinner spinner = new SpinnerBuilder(parent).setWidgets(widgets).setInvoker(invoker)
				.setBounds(108, 169, 108, 39).build();
		widgets.setBuildSpinner(spinner);
	}

	/**
	 * Buttons
	 */

	public static void createButtonRefresh(Composite parent, Widgets widgets, Invoker invoker) {
		Command command = new RefreshCommand(new Receiver(widgets, parent));

		new ButtonBuilder(parent).setWidgets(widgets).setInvoker(invoker).setCommand(command).setBounds(24, 235, 82, 27)
				.setText(Messages.refreshButton).build();
	}

	public static void createButtonGenerate(Composite parent, Widgets widgets, Invoker invoker) {
		Command command = new GenerateCommand(new Receiver(widgets, parent));

		new ButtonBuilder(parent).setWidgets(widgets).setInvoker(invoker).setCommand(command)
				.setBounds(134, 235, 82, 27).setText(Messages.generateButton).build();
	}
}
