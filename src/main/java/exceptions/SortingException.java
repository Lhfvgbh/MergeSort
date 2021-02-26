package exceptions;

public class SortingException extends Exception {
    private static final String errorMessage = "Program failed! Error sorting files!";

    public SortingException(String errorMessage) {
        super("Program failed! " + errorMessage);
    }
}
