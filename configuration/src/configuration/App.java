package configuration;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		Configuration configuration = new Configuration("D:\\configFile.txt");
		
		configuration.parse();
		
		String resultFilename = configuration.getResultFilename();
		System.out.println("resultFilename = " + resultFilename);
		
		String templateFilename = configuration.getTemplateFilename();
		System.out.println("resultFilename = " + templateFilename);
		
	}

}
