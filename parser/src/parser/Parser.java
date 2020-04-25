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

		//String number = statement.replaceAll("[^0-9?]", "");
		
		int number = detectNumber(statement);

		System.out.println("number = " + number);

		//return (Integer.parseInt(number));
		return number;
	}

	private int detectNumber(String s) {
		String number = s.replaceAll("[^0-9?]", "");

		return (Integer.parseInt(number));
	}

}
