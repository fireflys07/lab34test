package Transport;

import java.util.ArrayList;
import java.util.Objects;

public class Carriage implements Movable {
    private ArrayList<Horse> horses;

    public Carriage(ArrayList<Horse> horses) {
        this.horses = horses;
    }

    public Carriage() {
        this.horses = new ArrayList<>();
    }

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void setHorses(ArrayList<Horse> horses) {
        this.horses = horses;
    }

    public void addHorse(Horse horse) {
        horses.add(horse);
    }

    public void dispatch() throws NotEnoughHorsesException, TooManyHorsesException {
        int horseCount = horses.size();
        if (horseCount < 2) {
            throw new NotEnoughHorsesException("Недостаточно лошадей для кареты. Лошадей: " + horseCount + ", требуется минимум: 2");
        }
        if (horseCount > 6) {
            throw new TooManyHorsesException("Слишком много лошадей для кареты. Лошадей: " + horseCount + ", максимум: 6");
        }
        System.out.println("Карета отправляется с " + horseCount + " лошадьми");
    }

    @Override
    public void move() {
        try {
            dispatch();
        } catch (NotEnoughHorsesException | TooManyHorsesException e) {
            System.out.println("Ошибка при отправке кареты: " + e.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carriage carriage = (Carriage) o;
        return Objects.equals(horses, carriage.horses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horses);
    }

    @Override
    public String toString() {
        return "Carriage{" +
                "horses=" + horses.size() +
                '}';
    }
}

