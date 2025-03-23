package exception;

public  class SplitOutOfRangeException extends InvalidSelectionException {
	private static final long serialVersionUID = 6L;

	public SplitOutOfRangeException() {
        super("Split distance is invalid");
    }

    public SplitOutOfRangeException(String message) {
        super(message);
    }
}