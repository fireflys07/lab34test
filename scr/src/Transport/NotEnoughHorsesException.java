package Transport;

public class NotEnoughHorsesException extends Exception {
    public NotEnoughHorsesException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Недостаточно лошадей принцесса не смогла приехать... " + super.getMessage();
    }
}

