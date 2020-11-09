package org.vergen.views.commands;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Composite;
import org.vergen.core.Generator;
import org.vergen.core.Parser;
import org.vergen.core.ParserException;
import org.vergen.core.Version;
import org.vergen.views.Widgets;
import org.vergen.preferences.Preferences;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
		Preferences preferences = new Preferences();
		
		String resultFilename = preferences.getResultFilename();
		
		String majorRegex = preferences.getMajorRegex();
		String minorRegex = preferences.getMinorRegex();
		String bugfixRegex = preferences.getBugfixRegex();
		String buildRegex = preferences.getBugfixRegex();
			
		try 
		{
			String resultFile = new String(Files.readAllBytes(Paths.get(resultFilename)));
			
			Parser majorParser  = new Parser(majorRegex);
			Parser minorParser  = new Parser(minorRegex);
			Parser bugfixParser = new Parser(bugfixRegex);
			Parser buildParser  = new Parser(buildRegex);

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
		catch (ParserException e) 
		{
			e.printStackTrace();
		}
	}

	public void generate() {
		Preferences preferences = new Preferences();
		String templateFilename = preferences.getTemplateFilename();
		String resultFilename = preferences.getResultFilename();

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
