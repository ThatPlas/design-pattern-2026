package fr.fges.exception;

public class UnsupportedFileExtension extends Exception{

    /**
     * Constructs an UnsupportedFileExtension with no detail message.
     */
    public UnsupportedFileExtension() {
        super();
    }

    /**
     * Constructs an UnsupportedFileExtension with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of this exception
     */
    public UnsupportedFileExtension(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs an UnsupportedFileExtension with the specified cause.
     *
     * @param cause the cause of this exception
     */
    public UnsupportedFileExtension(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs an UnsupportedFileExtension with the specified detail message, cause,
     * suppression enabled or disabled, and writable stack trace enabled or disabled.
     *
     * @param message the detail message
     * @param cause the cause of this exception
     * @param enableSuppression whether suppression is enabled
     * @param writableStackTrace whether the stack trace should be writable
     */
    protected UnsupportedFileExtension(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * Constructs an UnsupportedFileExtension with the specified detail message.
     *
     * @param message the detail message
     */
    public UnsupportedFileExtension(String message) {
        super(message);
    }
}
