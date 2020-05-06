package com.github.FrankSchumann.jinjava_maven;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.util.*;

import com.hubspot.jinjava.Jinjava;

public class App 
{
    public static void main( String[] args )
    {
    	try {
			System.out.println("start - generate PacDriveConfigVersion.hpp");

			Jinjava jinjava2 = new Jinjava();

			Map<String, Object> context = new HashMap<>();
			context.put("major", "1");
			context.put("minor", "64");
			context.put("bugfix", "4");
			context.put("build", "3");

			String template = new String(Files.readAllBytes(Paths.get("jinja/PacConfigVersion.jinja")));

			String renderedTemplate = jinjava2.render(template, context);
			System.out.println(renderedTemplate);

			Path pacConfigVersionPath = Paths.get("/home/frank/PacConfigVersion.hpp");

			Files.write(pacConfigVersionPath, renderedTemplate.getBytes(), StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING);
			
			System.out.println("end - generate PacDriveConfigVersion.hpp success");

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
