package fr.fges.exception;

public class UnsupportedFileExtension extends Exception{

    public UnsupportedFileExtension() {
        super();
    }

    public UnsupportedFileExtension(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedFileExtension(Throwable cause) {
        super(cause);
    }

    protected UnsupportedFileExtension(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UnsupportedFileExtension(String message) {
        super(message);
    }
}
