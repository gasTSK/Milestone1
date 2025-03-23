package exception;

public class IllegalMovementException extends ActionException {
	private static final long serialVersionUID = 7L;


	public IllegalMovementException() {
        super("Illegal marble movement detected.");
    }

   
    public IllegalMovementException(String message) {
        super(message);
    }
}