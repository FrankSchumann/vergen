package parser;

import java.util.*;
import java.util.regex.*;

public class Parser {
	String regEx = "";
	
	public Parser(String regEx) {
		this.regEx = regEx;
	}

	public int parseStatement(String statement) {
		System.out.println("run");
		
		String line = getRegExMatch(statement);
		
		System.out.println("line = " + line);
		
		int number = detectNumber(line);

		System.out.println("number = " + number);

		return number;
	}
	
	private String getRegExMatch(String statement)
	{
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(statement);
		
		String result = "";
		if (matcher.find()) {
		    result = matcher.group();
		    System.out.println("result = " + result);
		}
		
		return result;
	}

	private int detectNumber(String input) {
		String number = input.replaceAll("[^0-9?]", "");
		
		System.out.println("number = " + number);

		return (Integer.parseInt(number));
	}

}
