package exception;

public class IllegalSwapException extends ActionException {
	private static final long serialVersionUID = 8L;

	public IllegalSwapException() {
        super("Illegal marble swap detected.");
    }

    public IllegalSwapException(String message) {
        super(message);
    }
}