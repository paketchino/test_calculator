package calculator.exception;

public class MyException extends Exception {

    public MyException(Throwable cause) {
        super(cause);
    }

    public MyException(String message) {
        super(message);
    }
}
