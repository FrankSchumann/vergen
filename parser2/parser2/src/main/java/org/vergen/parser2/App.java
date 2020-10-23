package org.vergen.parser2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		try {

			System.out.println("Hello World!");

			String pacConfigVersion = new String(Files.readAllBytes(Paths.get("D:\\git\\vergen\\examples\\PacConfigVersion.hpp")));

			Parser majorParser  = new Parser("FW_VERSION_MAJOR  = \\d*;");
			Parser minorParser  = new Parser("FW_VERSION_MINOR  = \\d*;");
			Parser bugfixParser = new Parser("FW_VERSION_BUGFIX = \\d*;");
			Parser buildParser  = new Parser("FW_VERSION_BUILD  = \\d*;");

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
