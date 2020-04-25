package parser;

public class Main 
{
 
       public static void main (String[] args)
       {
             System.out.println("Hello World!");
             
             Parser parser = new Parser(".");
             
             int major = parser.parseStatement("FW_VERSION_MAJOR  = 1;");
             
             System.out.println("major = " + major);
       }
}