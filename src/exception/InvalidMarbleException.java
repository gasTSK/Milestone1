package exception;

public  class InvalidMarbleException extends InvalidSelectionException{
	private static final long serialVersionUID = 4L;
	public InvalidMarbleException() {
	        super();
	    }
	 public InvalidMarbleException(String message) {
	        super(message);
	    }

	}