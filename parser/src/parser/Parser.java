package parser;

import java.util.*;
import java.util.regex.*;

public class Parser {
	String regEx = "";

	int major = 0;
	int minor = 0;
	int bugfix = 0;
	int build = 0;

	public int getMajor() {
		return major;
	}

	public int getMinor() {
		return minor;
	}

	public int getBugfix() {
		return bugfix;
	}

	public int getBuild() {
		return build;
	}


	public Parser(String regEx) {
		this.regEx = regEx;
	}

	public int parseStatement(String statement) {
		System.out.println("run");
		
		String number = statement.replaceAll("[^0-9?]", "");

		System.out.println("number = " + number);
		
		return(Integer.parseInt(number));
	}

}
