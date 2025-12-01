package Transport;

public class TooManyHorsesException extends Exception {
    public TooManyHorsesException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Слишком много лошадей, карета сломалась.. " + super.getMessage();
    }
}

