package org.vergen.generator;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Generator generator = new Generator("D:\\git\\vergen\\jinja\\PacConfigVersion.jinja", "D:\\PacConfigVersion.hpp");
    	
    	generator.setMajor(1);
    	generator.setMinor(64);
    	generator.setBugfix(5);
    	generator.setBuild(8);
    	
    	generator.render();
    }
}
