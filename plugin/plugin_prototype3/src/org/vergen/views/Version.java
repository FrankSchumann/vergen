package org.vergen.views;

public class Version {
	
	private int major;
	private int minor;
	private int bugfix;
	private int build;
	
	public Version(int major, int minor, int bugfix, int build) {
		this.major = major;
		this.minor = minor;
		this.bugfix = bugfix;
		this.build = build;
	}
	
	public String toString() {
		String majorTmp = Integer.toString(major);
		String minorTmp = Integer.toString(minor);
		String bugfixTmp = Integer.toString(bugfix);
		String buildTmp = Integer.toString(build);

		return majorTmp + "." + minorTmp + "." + bugfixTmp + "." + buildTmp;
	}

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

}
