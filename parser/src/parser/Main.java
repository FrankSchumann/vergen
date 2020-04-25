package parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {

		try {

			System.out.println("Hello World!");

			String pacConfigVersion = new String(Files.readAllBytes(Paths.get("examples/PacConfigVersion.hpp")));
			
			System.out.println("pacConfigVersion = " + pacConfigVersion);

			Parser majorParser = new Parser("FW_VERSION_MAJOR  = 1;");
			Parser minorParser = new Parser("FW_VERSION_MINOR  = 64;");
			Parser bugfixParser = new Parser("FW_VERSION_BUGFIX = 4;");
			Parser buildParser = new Parser("FW_VERSION_BUILD  = 3;");

			int major = majorParser.parseStatement("FW_VERSION_MAJOR  = 1;");
			int minor = minorParser.parseStatement("FW_VERSION_MINOR  = 64;");
			int bugfix = bugfixParser.parseStatement("FW_VERSION_BUGFIX  = 4;");
			int build = buildParser.parseStatement("FW_VERSION_BUILD  = 3;");

			System.out.println("major = " + major);
			System.out.println("minor = " + minor);
			System.out.println("bugfix = " + bugfix);
			System.out.println("build = " + build);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}