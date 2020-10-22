package com.schneider_electric.quickstart;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

import com.hubspot.jinjava.Jinjava;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {	
    	Generator generator = new Generator("D:\\git\\vergen\\jinja\\PacConfigVersion.jinja", "D:\\PacConfigVersion.hpp");
    	
    	generator.setMajor(1);
    	generator.setMinor(64);
    	generator.setBugfix(5);
    	generator.setBuild(7);
    	
    	generator.render();
    }
}
