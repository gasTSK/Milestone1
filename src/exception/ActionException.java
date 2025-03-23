package exception;

abstract class ActionException extends GameException {
	private static final long serialVersionUID = 3L;


	public ActionException() {
        super("illegal action performed");
    }

   
    public ActionException(String message) {
        super(message);	
    }
    }