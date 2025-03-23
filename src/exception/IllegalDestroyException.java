package exception;

public class IllegalDestroyException extends ActionException {
	private static final long serialVersionUID = 9L;

	public
IllegalDestroyException() {
        super("Illegal destroy action detected.");
    }

    public IllegalDestroyException(String message) {
        super(message);
    }
}