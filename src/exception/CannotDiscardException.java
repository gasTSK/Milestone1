package exception;

public class CannotDiscardException extends ActionException {

	private static final long serialVersionUID = 11L;
	public CannotDiscardException() {
        super("Cannot discard the selected.");
	}
    
public CannotDiscardException(String message) {
        super(message);
    }
}