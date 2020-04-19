package jinjavatest;

import com.hubspot.jinjava.Jinjava;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.util.*;


public class Main {
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		try
		{
			Path path = Paths.get("/home/frank/test.txt");
			byte[] fileContentBytes = Files.readAllBytes(path);
			String content = new String(fileContentBytes);
			
			System.out.println(content);
			
//			String content = new String(Files.readAllBytes(Paths.get("test.txt")));
			
			String template_1 = new String(Files.readAllBytes(Paths.get("jinja/template#1.jinja")));
			System.out.println(template_1);
		
			Jinjava jinjava2 = new Jinjava();
			
			Map<String, Object> context = new HashMap<>();
			context.put("name", "Jared");
			
			String template = "Hello, {{ name }}";
			String renderedTemplate = jinjava2.render(template, context);
			
			System.out.println(renderedTemplate);
			
			Map<String, Object> context_1 = new HashMap<>();
			context_1.put("name", "Frank");
			
			String renderedTemplate_1 = jinjava2.render(template_1, context_1);
			System.out.println(renderedTemplate_1);
			
			Path pathOutputFile = Paths.get("/home/frank/output.txt");
			
			if(false == Files.exists(pathOutputFile)){
			  //  Files.createFile(pathOutputFile);
			}
			
			Files.write(pathOutputFile, renderedTemplate_1.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		
		
		}
		catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
	}

}
