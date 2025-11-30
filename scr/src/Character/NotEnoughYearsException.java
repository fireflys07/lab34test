public class NotEnoughYearsException extends Exception {
    public NotEnoughYearsException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Недостаточно лет службы: " + super.getMessage();
    }
}

