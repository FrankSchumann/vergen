package parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {

		try {

			System.out.println("Hello World!");

			String pacConfigVersion = new String(Files.readAllBytes(Paths.get("examples/PacConfigVersion.hpp")));

			Parser majorParser  = new Parser("FW_VERSION_MAJOR  = \\d;");
			Parser minorParser  = new Parser("FW_VERSION_MAJOR  = \\d;");
			Parser bugfixParser = new Parser("FW_VERSION_BUGFIX = \\d;");
			Parser buildParser  = new Parser("FW_VERSION_BUILD  = \\d;");

			int major = majorParser.parseStatement(pacConfigVersion);
			int minor = minorParser.parseStatement(pacConfigVersion);
			int bugfix = bugfixParser.parseStatement(pacConfigVersion);
			int build = buildParser.parseStatement(pacConfigVersion);

			System.out.println("major = " + major);
			System.out.println("minor = " + minor);
			System.out.println("bugfix = " + bugfix);
			System.out.println("build = " + build);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}