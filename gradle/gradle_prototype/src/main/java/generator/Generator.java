package generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

public class Generator {
	Path templatePath;

	Map<String, Object> context;

	public void setTemplateFile(String fileName) {
		this.templatePath = Paths.get(fileName);
	}

	public Generator(String templateFileName) {
		this.templatePath = Paths.get(templateFileName);
	}

	public void generate(String outputFileName) {
		try {
			String template = new String(Files.readAllBytes(templatePath));

//		String renderedTemplate = jinjava2.render(template, context);
			String renderedTemplate = "";

			Path outputFileNamePath = Paths.get(outputFileName);

			Files.write(outputFileNamePath, renderedTemplate.getBytes(), StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING);
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setVersion(String major, String minor, String bugfix, String build) {
		context = new HashMap<>();

		context.put("major", major);
		context.put("minor", minor);
		context.put("bugfix", bugfix);
		context.put("build", build);
	}

}
