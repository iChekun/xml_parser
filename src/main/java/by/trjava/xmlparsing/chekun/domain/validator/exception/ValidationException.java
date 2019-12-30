package by.trjava.xmlparsing.chekun.domain.validator.exception;

public class ValidationException extends Exception {


    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }


}
