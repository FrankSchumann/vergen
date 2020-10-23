package configuration;

import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Configuration {
	
	String configurationFilename = "D:\\configFile.txt";
	String resultFilename = "D:\\PacConfigVersionDefault.hpp";
	String templateFilename = "D:\\git\\vergen\\jinja\\PacConfigVersionDefault.jinja";
	Properties properties;
	
	public Configuration(String configurationFilename) {
		this.configurationFilename = configurationFilename;
		properties = new Properties();
	}
	
	public String getResultFilename() {
		return resultFilename;
	}
	
	public String getTemplateFilename() {
		return templateFilename;
	}
	
	public void parse()
	{
		InputStream is = null;
		
		try {
		    is = new FileInputStream(configurationFilename);
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		try {
			properties.load(is);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		
		resultFilename = properties.getProperty("resultFilename");
		templateFilename = properties.getProperty("templateFilename");
	}

}
