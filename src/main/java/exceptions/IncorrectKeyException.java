package exceptions;

public class IncorrectKeyException extends Exception {
    private static final String errorMessage = "Program failed! Incorrect command parameters!\n" +
            "Use -i for numeric sorting or -s for alphabetic (required)\n" +
            "Use -a for ascending sorting or -d for descending (optional, default -a)\n";

    public IncorrectKeyException() {
        super(errorMessage);
    }
}
