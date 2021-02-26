package exceptions;

public class SortingException extends Exception {
    public SortingException(String errorMessage) {
        super("Program failed! " + errorMessage);
    }
}
