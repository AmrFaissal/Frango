package eu.people1.frango.exception;

public class FileParsingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public FileParsingException() {
		
	}

	public FileParsingException(String message) {
		super(message);
	}

	public FileParsingException(String message, Exception exception) {
		super(message, exception);
	}

}
