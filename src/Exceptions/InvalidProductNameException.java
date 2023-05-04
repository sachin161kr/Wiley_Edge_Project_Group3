package Exceptions;

public class InvalidProductNameException extends Throwable {
    public InvalidProductNameException(String s) {
        super(s);
    }
}
