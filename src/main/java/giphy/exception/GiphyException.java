package giphy.exception;

public class GiphyException extends Exception {
	
	private static final long serialVersionUID = -2564399168708610588L;

    /**
     * Constructs a new exception.
     */
    public GiphyException() {
	super();
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     * 
     * @param message
     *            the detail message
     * @param cause
     *            the cause
     */
    public GiphyException(String message, Throwable cause) {
	super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     * 
     * @param message
     *            the detail message
     */
    public GiphyException(String message) {
	super(message);
    }

    /**
     * Constructs a new exception with the specified cause.
     * 
     * @param cause
     *            the cause
     */
    public GiphyException(Throwable cause) {
	super(cause);
    }
	
}