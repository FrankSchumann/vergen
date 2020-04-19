package jinjavatest;

import com.hubspot.jinjava.Jinjava;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
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
		}
		catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
		
		
		Jinjava jinjava2 = new Jinjava();
		
		Map<String, Object> context = new HashMap<>();
		context.put("name", "Jared");
		
		String template = "Hello, {{ name }}";
		String renderedTemplate = jinjava2.render(template, context);
		
		System.out.println(renderedTemplate);
	}

}
