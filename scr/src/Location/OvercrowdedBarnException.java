package Location;

public class OvercrowdedBarnException extends Exception {
    public OvercrowdedBarnException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "В амбаре оказалось слишком много людей..  " + super.getMessage();
    }
}

