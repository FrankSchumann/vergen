package org.vergen.views.commands;


import org.eclipse.swt.widgets.Composite;
import org.vergen.generator.Generator;
import org.vergen.views.Version;
import org.vergen.views.Widgets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.eclipse.jface.dialogs.MessageDialog;

import org.vergen.parser2.Parser;

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
		
		String pacConfigVersion = null;
		
		try 
		{
			pacConfigVersion = new String(Files.readAllBytes(Paths.get("C:\\Dev\\Vergen\\examples\\PacConfigVersion.hpp")));
			
		} 
		catch (IOException e) 
		{			
			e.printStackTrace();
		}

		Parser majorParser  = new Parser("FW_VERSION_MAJOR  = \\d*;");
		Parser minorParser  = new Parser("FW_VERSION_MINOR  = \\d*;");
		Parser bugfixParser = new Parser("FW_VERSION_BUGFIX = \\d*;");
		Parser buildParser  = new Parser("FW_VERSION_BUILD  = \\d*;");

		int major = majorParser.parseStatement(pacConfigVersion);
		int minor = minorParser.parseStatement(pacConfigVersion);
		int bugfix = bugfixParser.parseStatement(pacConfigVersion);
		int build = buildParser.parseStatement(pacConfigVersion);


		Version version = new Version(major, minor, bugfix, build);

		widgets.setVersion(version);
	}

	public void generate() {
		Version version = widgets.getVersion();

		// TODO add generator
/*		Test test = new Test();
		
		test.run();
		*/
		
		String templateFileName = "D:\\git\\vergen\\jinja\\PacConfigVersion.jinja";
		String resultFileName = "D:\\PacConfigVersion.hpp";

		Generator generator = new Generator(templateFileName, resultFileName);
    	
		int major = version.getMajor();
		int minor = version.getMinor();
		int bugfix = version.getBugfix();
		int build = version.getBuild();

		generator.setMajor(major);
    	generator.setMinor(minor);
    	generator.setBugfix(bugfix);
    	generator.setBuild(build);
    	
    	generator.render();

		String message = "File " + resultFileName + " generated with version " + version.toString();

		showMessage(parent, message);
	};

	private void showMessage(Composite parent, String message) {
		MessageDialog.openInformation(parent.getShell(), "VerGen View", message);
	}

}
