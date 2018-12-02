package exceptions;

public class ZeroFCException extends Exception {
    public ZeroFCException() {
    }

    public ZeroFCException(String message) {
        super(message);
    }

    public ZeroFCException(String message, Throwable cause) {
        super(message, cause);
    }

    public ZeroFCException(Throwable cause) {
        super(cause);
    }
    public static void printErrorMessage(){
        System.out.println("Fuel consumption cannot be 0");
    }
}
