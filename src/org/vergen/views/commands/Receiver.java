package org.vergen.views.commands;


import org.eclipse.swt.widgets.Composite;
import org.vergen.core.Generator;
import org.vergen.core.Parser;
import org.vergen.core.Version;
import org.vergen.views.Widgets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.eclipse.jface.dialogs.MessageDialog;

public class Receiver {

	private Widgets widgets;
	private Composite parent;
	private static String resultFilename = null;
	private static String templateFilename = null;

	public Receiver(Widgets widgets, Composite parent) {
		this.widgets = widgets;
		this.parent = parent;
	}

	public void updateView() {
		Version version = widgets.getVersion();
		
		widgets.setVersion(version);
	}

	public void refresh() {
		
		// TODO read result file name from configuration/preferences
		
		// TODO remove static file names
		templateFilename = "D:\\git\\playground\\jinja\\PacConfigVersion.jinja";
		resultFilename = "D:\\git\\playground\\examples\\PacConfigVersion.hpp";
		
		// TODO read regex from configuration/preferences
			
		try 
		{
			String resultFile = new String(Files.readAllBytes(Paths.get(resultFilename)));
			
			Parser majorParser  = new Parser("FW_VERSION_MAJOR  = \\d*;");
			Parser minorParser  = new Parser("FW_VERSION_MINOR  = \\d*;");
			Parser bugfixParser = new Parser("FW_VERSION_BUGFIX = \\d*;");
			Parser buildParser  = new Parser("FW_VERSION_BUILD  = \\d*;");

			int major = majorParser.parseStatement(resultFile);
			int minor = minorParser.parseStatement(resultFile);
			int bugfix = bugfixParser.parseStatement(resultFile);
			int build = buildParser.parseStatement(resultFile);


			Version version = new Version(major, minor, bugfix, build);

			widgets.setVersion(version);
		
		
		} 
		catch (IOException e) 
		{			
			e.printStackTrace();
		}
	}

	public void generate() {
		// TODO read templateFilename and resultFilename from preferences
		Generator generator = new Generator(templateFilename, resultFilename);

		Version version = widgets.getVersion();
		generator.setVersion(version);
	
    	generator.render();

		String message = "File " + resultFilename + " generated with version " + version.toString();

		showMessage(parent, message);
	};

	private void showMessage(Composite parent, String message) {
		MessageDialog.openInformation(parent.getShell(), "VerGen View", message);
	}

}
