package jinjavatest;

import com.hubspot.jinjava.Jinjava;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		Jinjava jinjava2 = new Jinjava();
		
		Map<String, Object> context = new HashMap<>();
		context.put("name", "Jared");
		
		String template = "Hello, {{ name }}";
		String renderedTemplate = jinjava2.render(template, context);
		
		System.out.println(renderedTemplate);
	}

}
