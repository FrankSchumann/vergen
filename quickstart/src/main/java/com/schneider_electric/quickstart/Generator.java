package com.schneider_electric.quickstart;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

import com.hubspot.jinjava.Jinjava;

public class Generator 
{
	String templateFile;
	String resultFile;
	String major = "0";
	String minor = "0";
	String bugfix = "0";
	String build = "0";
	
	public Generator(String templateFile, String resultFile) {
		this.templateFile = templateFile;
		this.resultFile = resultFile;
	}

	public void render() {
		try	{
			Jinjava jinjava2 = new Jinjava();
	
			Map<String, Object> context = new HashMap<>();
			context.put("major", major);
			context.put("minor", minor);
			context.put("bugfix", bugfix);
			context.put("build", build);
	
			String template = new String(Files.readAllBytes(Paths.get(templateFile)));
	
			String renderedTemplate = jinjava2.render(template, context);
	
			Path resultPath = Paths.get(resultFile);
	
			Files.write(resultPath, renderedTemplate.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setMajor(int major) {
		this.major = Integer.toString(major);
	}
	
	public void setMinor(int minor) {
		this.minor = Integer.toString(minor);
	}

	public void setBugfix(int bugfix) {
		this.bugfix = Integer.toString(bugfix);
	}

	public void setBuild(int build) {
		this.build = Integer.toString(build);
	}
	
}
