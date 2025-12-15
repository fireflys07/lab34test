package Character;

import java.util.Objects;

public class Gans extends Character {
    private int yearsServed;
    private int dirtLevel;

    public Gans(String name, int yearsServed, int dirtLevel, Status status, CharacterAttributes attributes) {
        super(name, status, attributes);
        this.yearsServed = yearsServed;
        this.dirtLevel = dirtLevel;
    }

    public Gans(String name, int yearsServed, int dirtLevel) {
        super(name, dirtLevel > 40 ? Status.DIRTY : Status.CLEAN, new CharacterAttributes(3, 4, 2));
        this.yearsServed = yearsServed;
        this.dirtLevel = dirtLevel;
    }

    public Gans() {
        super("Ганс", Status.COMMON, new CharacterAttributes(3, 4, 2));
        this.yearsServed = 0;
        this.dirtLevel = 0;
    }

    public int getYearsServed() {
        return yearsServed;
    }

    public void setYearsServed(int yearsServed) {
        this.yearsServed = yearsServed;
    }

    public int getDirtLevel() {
        return dirtLevel;
    }

    public void setDirtLevel(int dirtLevel) {
        this.dirtLevel = dirtLevel;
    }

    public void presentToPrincess() throws NotEnoughYearsException {

        if (dirtLevel > 100) {
            throw new TooDirtyRuntimeException("Ганс слишком грязный для представления принцессе. Уровень грязи: " + dirtLevel);
        }

        if (yearsServed < 7) {
            throw new NotEnoughYearsException("Ганс служил недостаточно долго. Лет службы: " + yearsServed + ", требуется: 7");
        }
        System.out.println("Ганс представляется принцессе");
    }

    public boolean isClean() {
        return dirtLevel <= 40;
    }

    public boolean servedHonestly() {
        return yearsServed >= 7;
    }

    @Override
    public void act() {
        System.out.println(getName() + " выполняет действие");
    }

    @Override
    public void speak() {
        System.out.println(getName() + " говорит");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gans gans = (Gans) o;
        return yearsServed == gans.yearsServed && dirtLevel == gans.dirtLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(yearsServed, dirtLevel);
    }

    @Override
    public String toString() {
        return "Gans{" +
                "yearsServed=" + yearsServed +
                ", dirtLevel=" + dirtLevel +
                '}';
    }
}
