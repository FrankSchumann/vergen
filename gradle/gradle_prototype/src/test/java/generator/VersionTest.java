package generator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

class VersionTest {
	
	Version version = new Version();
	
	@Test
	void setMajorTest() {
		
		version.setMajor(0);
		version.setMajor(2);
		version.setMajor(10);
		version.setMajor(99);
		
		Exception exception;
		String expectedMessage = "Version not in range (0-99)";
	    String actualMessage = "";
		
		exception= assertThrows(VersionException.class, () -> {
			version.setMajor(100);
	    });
		
	    actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
		
	    exception= assertThrows(VersionException.class, () -> {
			version.setMajor(100);
	    });
		
	    actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	    
	    exception= assertThrows(VersionException.class, () -> {
			version.setMajor(200);
	    });
		
	    actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	    
	    exception= assertThrows(VersionException.class, () -> {
			version.setMajor(-3);
	    });
		
	    actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void setMinorTest() {
		version.setMinor(0);
		version.setMinor(2);
		version.setMinor(10);
		version.setMinor(99);
		
		Exception exception;
		String expectedMessage = "Version not in range (0-99)";
	    String actualMessage = "";
		
		exception= assertThrows(VersionException.class, () -> {
			version.setMinor(100);
	    });
		
	    actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
		
	    exception= assertThrows(VersionException.class, () -> {
			version.setMinor(100);
	    });
		
	    actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	    
	    exception= assertThrows(VersionException.class, () -> {
			version.setMinor(200);
	    });
		
	    actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	    
	    exception= assertThrows(VersionException.class, () -> {
			version.setMinor(-3);
	    });
		
	    actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void setBugfixTest() {
		version.setBugfix(0);
		version.setBugfix(2);
		version.setBugfix(10);
		version.setBugfix(99);
		
		Exception exception;
		String expectedMessage = "Version not in range (0-99)";
	    String actualMessage = "";
		
		exception= assertThrows(VersionException.class, () -> {
			version.setBugfix(100);
	    });
		
	    actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
		
	    exception= assertThrows(VersionException.class, () -> {
			version.setBugfix(100);
	    });
		
	    actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	    
	    exception= assertThrows(VersionException.class, () -> {
			version.setBugfix(200);
	    });
		
	    actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	    
	    exception= assertThrows(VersionException.class, () -> {
			version.setBugfix(-3);
	    });
		
	    actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void setBuildTest() {
		version.setBuild(0);
		version.setBuild(2);
		version.setBuild(10);
		version.setBuild(99);
		
		Exception exception;
		String expectedMessage = "Version not in range (0-99)";
	    String actualMessage = "";
		
		exception= assertThrows(VersionException.class, () -> {
			version.setBuild(100);
	    });
		
	    actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
		
	    exception= assertThrows(VersionException.class, () -> {
			version.setBuild(100);
	    });
		
	    actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	    
	    exception= assertThrows(VersionException.class, () -> {
			version.setBuild(200);
	    });
		
	    actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	    
	    exception= assertThrows(VersionException.class, () -> {
			version.setBuild(-3);
	    });
		
	    actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void setTest() {
		version.set(1, 64, 4, 5);
		version.set(0, 0, 0, 0);
		version.set(1, 64, 4, 99);
		version.set(99, 99, 99, 99);
		
		Exception exception;
		String expectedMessage = "Version not in range (0-99)";
	    String actualMessage = "";
		
		exception= assertThrows(VersionException.class, () -> {
			version.set(100, 100, 100, 100);
	    });
		
	    actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	    
	    exception= assertThrows(VersionException.class, () -> {
			version.set(100, 64, 4, 3);
	    });
		
	    actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	    
	    exception= assertThrows(VersionException.class, () -> {
			version.set(1, 64, 4, -3);
	    });
		
	    actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	    
	    exception= assertThrows(VersionException.class, () -> {
			version.set(-2, -4, -5, -6);
	    });
		
	    actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	
	@Test
	void getContextTest() {
		version.set(1, 64, 4, 5);
		Map<String, Object> context = version.getContext(); 
		
		Object objectMajor = context.get("major");
		String major = objectMajor.toString();
		assertTrue(major.contains("1"));
		
		Object objectMinor = context.get("minor");
		String minor = objectMinor.toString();
		assertTrue(minor.contains("64"));
		
		Object objectBugfix = context.get("bugfix");
		String bugfix = objectBugfix.toString();
		assertTrue(bugfix.contains("4"));
		
		Object objectBuild = context.get("build");
		String build = objectBuild.toString();
		assertTrue(build.contains("5"));
	}
	

}
