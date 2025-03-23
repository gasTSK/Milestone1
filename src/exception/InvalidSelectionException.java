package exception;

abstract class InvalidSelectionException extends Exception {
	private static final long serialVersionUID = 2L;


	public InvalidSelectionException() {
        super();
    }

 
    public InvalidSelectionException(String message) {
        super(message);
    }
}
