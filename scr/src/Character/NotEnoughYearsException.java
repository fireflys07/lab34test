package Character;

public class NotEnoughYearsException extends Exception {
    public NotEnoughYearsException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Кто ты такой??? *принцесса не узнала Ганса, он не достаточно служил* " + super.getMessage();
    }
}

