package generator;

import java.util.HashMap;
import java.util.Map;

public class Version {
	String major = "0";
	String minor = "0";
	String bugfix = "0";
	String build = "0";

	public Version() {

	}

	public void setMajor(int major) {
		this.major = getString(major);
	}

	public void setMinor(int minor) {
		this.minor = getString(minor);
	}

	public void setBugfix(int bugfix) {
		this.bugfix = getString(bugfix);
	}

	public void setBuild(int build) {
		this.build = getString(build);
	}
	
	public void set(int major, int minor, int bugfix, int build) {
		this.major = getString(major);
		this.minor = getString(minor);
		this.bugfix = getString(bugfix);
		this.build = getString(build);
	}
	
	private String getString(int number) throws VersionException
	{
		if (number < 0 || number > 99) {
			throw new VersionException("version not in range (0-99)");
		}
		
		return Integer.toString(number);
	}
	
	public Map<String, Object> getContext() {
		Map<String, Object> context = new HashMap<>(); 
		
		context.put("major", major);
		context.put("minor", minor);
		context.put("bugfix", bugfix);
		context.put("build", build);
		
		return context;
	}

}
