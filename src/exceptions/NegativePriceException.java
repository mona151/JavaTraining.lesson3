package exceptions;

public class NegativePriceException extends Exception {
    public NegativePriceException() {
    }

    public NegativePriceException(String message) {
        super(message);
    }

    public NegativePriceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativePriceException(Throwable cause) {
        super(cause);
    }
    public static void printErrorMessage(){
        System.out.println("Price cannot be negative or 0");
    }
}
