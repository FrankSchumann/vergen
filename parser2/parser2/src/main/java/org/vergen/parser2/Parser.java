package org.vergen.parser2;

import java.util.regex.*;

public class Parser {
	String regEx = "";

	public Parser(String regEx) {
		this.regEx = regEx;
	}

	public int parseStatement(String statement) {

		String line = getRegExMatch(statement);

		int number = detectNumber(line);

		return number;
	}

	private String getRegExMatch(String statement) throws ParserException {
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(statement);

		String result = "";
		if (matcher.find()) {
			result = matcher.group();
		} else {
			throw new ParserException("regEx doesn't match");
		}

		return result;
	}

	private int detectNumber(String input) {
		String number = input.replaceAll("[^0-9?]", "");

		return (Integer.parseInt(number));
	}

}
