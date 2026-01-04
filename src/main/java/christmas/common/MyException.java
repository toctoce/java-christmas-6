package christmas.common;

public class MyException extends IllegalArgumentException {
    public MyException(String message) {
        super("[ERROR] " + message);
    }
}