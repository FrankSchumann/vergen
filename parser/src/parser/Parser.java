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
		
		String line = statement.replaceAll(regEx, "");
		
		System.out.println("line = " + line);
		
		int number = detectNumber(statement);

		System.out.println("number = " + number);

		return number;
	}

	private int detectNumber(String input) {
		String number = input.replaceAll("[^0-9?]", "");

		return (Integer.parseInt(number));
	}

}
