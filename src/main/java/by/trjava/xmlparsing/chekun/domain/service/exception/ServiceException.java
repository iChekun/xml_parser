package by.trjava.xmlparsing.chekun.domain.service.exception;

public class ServiceException extends Exception {


    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }


}
