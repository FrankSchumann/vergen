package generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import com.hubspot.jinjava.Jinjava;

public class Generator {
	Path templatePath;
	Version version;

	public void setTemplateFile(String fileName) {
		this.templatePath = Paths.get(fileName);
	}

	public Generator(String templateFileName) {
		this.templatePath = Paths.get(templateFileName);
	}

	public void generate(String outputFileName) {
		try {
			String template = new String(Files.readAllBytes(templatePath));
			
			Map<String, Object> context = version.getContext();
			
			Jinjava jinjava2 = new Jinjava();
			
			String renderedTemplate = jinjava2.render(template, context);

			Path outputFileNamePath = Paths.get(outputFileName);

			Files.write(outputFileNamePath, renderedTemplate.getBytes(), StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING);
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setVersion(Version version) {
		this.version = version;
	}

}
