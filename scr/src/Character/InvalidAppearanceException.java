public class InvalidAppearanceException extends Exception {
    public InvalidAppearanceException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Неверный внешний вид: " + super.getMessage();
    }
}

