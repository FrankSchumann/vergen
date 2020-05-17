package org.upsilon.vergen.core.generator;

public class VersionException extends RuntimeException {

	public static final String VERSION_NOT_IN_RANGE = "Version not in range (0-99)";
	
	private static final long serialVersionUID = 6877869655700066145L;
	
	public VersionException() {
	}

	public VersionException(String s) {
		super(s);
	}
}
