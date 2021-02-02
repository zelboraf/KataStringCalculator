public class NegativeNumberException extends RuntimeException{
    private final String message;

    public NegativeNumberException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
