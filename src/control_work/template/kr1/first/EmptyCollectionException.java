package control_work.template.kr1.first;

public class EmptyCollectionException extends Exception {
    public EmptyCollectionException() {
    }

    public EmptyCollectionException(String message) {
        super(message);
    }

    public EmptyCollectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyCollectionException(Throwable cause) {
        super(cause);
    }

    public EmptyCollectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
