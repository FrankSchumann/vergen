package org.vergen.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.hubspot.jinjava.Jinjava;

public class Generator 
{
	String templateFile;
	String resultFile;
	Version version = null;
	
	public Generator(String templateFile, String resultFile) {
		this.templateFile = templateFile;
		this.resultFile = resultFile;
	}

	public void render() {
		try	{
			Jinjava jinjava2 = new Jinjava();
			
			Map<String, Object> context = version.getContext();
	
			String template = new String(Files.readAllBytes(Paths.get(templateFile)));
	
			String renderedTemplate = jinjava2.render(template, context);
	
			Path resultPath = Paths.get(resultFile);
	
			Files.write(resultPath, renderedTemplate.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setVersion(Version version) {
		this.version = version;
	}
	
}
