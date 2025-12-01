package Character;

public class ExcessiveDirtException extends Exception {
    public ExcessiveDirtException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Превышен допустимый уровень грязи: " + super.getMessage();
    }
}

