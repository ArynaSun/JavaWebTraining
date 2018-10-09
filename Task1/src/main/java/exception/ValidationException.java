package exception;

public class ValidationException extends Exception {
    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(Exception e) {
        super(e);
    }

    public ValidationException(String message, Exception e) {
        super(message, e);
    }
}
