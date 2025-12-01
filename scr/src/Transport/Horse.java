package Transport;

import java.util.Objects;

public class Horse extends Animal implements Movable {
    private int speed;

    public Horse(int speed) {
        this.speed = speed;
    }

    public Horse() {
        this.speed = 10;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void run() {
        System.out.println("Лошадь бежит со скоростью " + speed);
    }

    @Override
    public void move() {
        run();
    }

    @Override
    public void sound() {
        System.out.println("И-го-го!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return speed == horse.speed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(speed);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "speed=" + speed +
                '}';
    }
}

