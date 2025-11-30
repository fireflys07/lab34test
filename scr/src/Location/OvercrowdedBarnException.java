public class OvercrowdedBarnException extends Exception {
    public OvercrowdedBarnException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Амбар переполнен: " + super.getMessage();
    }
}

