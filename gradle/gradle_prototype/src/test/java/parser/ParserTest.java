package parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

class ParserTest {

	static Parser parserMajor;
	static Parser parserMinor;
	static Parser parserBugfix;
	static Parser parserBuild;
	static String testStringLong;

	@BeforeAll
	public static void beforeAll() {

		parserMajor = new Parser("FW_VERSION_MAJOR  = \\d*;");
		parserMinor = new Parser("FW_VERSION_MINOR  = \\d*;");
		parserBugfix = new Parser("FW_VERSION_BUGFIX = \\d*;");
		parserBuild = new Parser("FW_VERSION_BUILD  = \\d*;");

		setSetTestStringLong();
	}

	@Test
	void parseStatementTest() {
		
		int major = 0;
		int minor = 0;
		int bugfix = 0;
		int build = 0;

		major = parserMajor.parseStatement(testStringLong);
		assertEquals(1, major);
		
		minor = parserMinor.parseStatement(testStringLong);
		assertEquals(64, minor);
		
		bugfix = parserBugfix.parseStatement(testStringLong);
		assertEquals(4, bugfix);
		
		build = parserBuild.parseStatement(testStringLong);
		assertEquals(3, build);
		
		major = parserMajor.parseStatement("const UINT8 FW_VERSION_MAJOR  = 22;\n" + "const UINT8 FW_VERSION_MINOR  = 64;\n");
		assertEquals(22, major);
		
		major = parserMajor.parseStatement("const UINT8 FW_VERSION_MAJOR  = 22665;\n" + "const UINT8 FW_VERSION_MINOR  = 64;\n");
		assertEquals(22665, major);
		
		minor = parserMinor.parseStatement("const UINT8 FW_VERSION_MAJOR  = 22665;\n" + "const UINT8 FW_VERSION_MINOR  = 04;\n");
		assertEquals(4, minor);
		
		Exception exception = assertThrows(ParserException.class, () -> {
			parserMinor.parseStatement("const UINT8 FW_VERSION_BUGFIX = 4;\n" + "const UINT8 FW_VERSION_BUILD  = 3;\n" + "\n");
	    });
		
		String expectedMessage = "regEx doesn't match";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	}

	private static void setSetTestStringLong() {

		testStringLong = "/**\n" + "* file generated by vergen\n" + "**/   \n" + "\n"
				+ "#ifndef __INC_PacConfigVersionHPP\n" + "#define __INC_PacConfigVersionHPP\n" + "\n"
				+ "const char FW_VERSION_3S_STRING[9]  = \"1.64.4.3\";\n" + "\n"
				+ "const UINT8 FW_VERSION_MAJOR  = 1;\n" + "const UINT8 FW_VERSION_MINOR  = 64;\n"
				+ "const UINT8 FW_VERSION_BUGFIX = 4;\n" + "const UINT8 FW_VERSION_BUILD  = 3;\n" + "\n"
				+ "const UINT32 FW_VERSION_UINT32 = 0x01400403;;\n" + "\n"
				+ "const char FW_VERSION_STRING[13]  = \"V01.64.04.03\";\n"
				+ "const int FW_VERSION_STRING_LENGTH  = 13;\n" + "\n"
				+ "const char FW_VERSION_STRING_USER[8]  = \"V1.64.4\";\n"
				+ "const int FW_VERSION_STRING_USER_LENGTH  = 8;\n" + "\n"
				+ "const char FW_VERSION_STRING_COMPLETE[10]  = \"V1.64.4.3\";\n"
				+ "const int FW_VERSION_STRING_COMPLETE_LENGTH  = 10;\n" + "\n" + "#ifdef FILE_PacDriveCPP\n"
				+ "   int g_lMax4VersionIdStart016404End;\n" + "   int g_lMax4Version2IdStart01_64_04_03End;\n"
				+ "#endif\n" + "\n" + "#endif //__INC_PacConfigVersionHPP";
	}

}
