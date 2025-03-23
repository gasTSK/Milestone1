package exception;

public class InvalidCardException extends InvalidSelectionException {
	private static final long serialVersionUID = 5L;

	public InvalidCardException() {
        super("Invalid card selection.");
    }

    public InvalidCardException(String message) {
        super(message);
    }

}