package exception;

public class CannotFieldException extends ActionException {
	private static final long serialVersionUID = 10L;


	public CannotFieldException() {
        super("Cannot field marble on the board.");
    }

   
    public CannotFieldException(String message) {
        super(message);
    }
}