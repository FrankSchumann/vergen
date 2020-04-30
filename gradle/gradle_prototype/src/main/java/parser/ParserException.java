package parser;

public class ParserException extends RuntimeException {


	public static final String REGEX_NO_MATCH = "RegEx doesn't match";
	
	private static final long serialVersionUID = 1254778942251857496L;

	public ParserException() {
	}

	public ParserException(String s) {
		super(s);
	}
}
