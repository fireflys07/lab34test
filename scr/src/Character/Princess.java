package Character;

import java.util.Objects;

public class Princess extends Character {
    private int statusLevel;

    public Princess(String name, int statusLevel, Status status, CharacterAttributes attributes) {
        super(name, status, attributes);
        this.statusLevel = statusLevel;
    }

    public Princess(String name, int statusLevel) {
        super(name, Status.ROYAL, new CharacterAttributes(1, 1, 10));
        this.statusLevel = statusLevel;
    }

    public Princess() {
        super("Принцесса", Status.ROYAL, new CharacterAttributes(1, 1, 10));
        this.statusLevel = 10;
    }

    public int getStatusLevel() {
        return statusLevel;
    }

    public void setStatusLevel(int statusLevel) {
        this.statusLevel = statusLevel;
    }

    public void recognize(Gans hans) {
        boolean isClean = hans.isClean();
        boolean servedEnough = hans.servedHonestly();

        if (isClean && servedEnough) {
            System.out.println("- О, вот же он, Великолепный Ганс!");
            System.out.println("ПОЗДРАВЛЯЮ! ВЫ ПОЛУЧИЛИ ХОРОШУЮ КОНЦОВКУ");
        } else if (!isClean && servedEnough) {
            System.out.println("- Ну ладно, держи лошадь");
            System.out.println("ПОЗДРАВЛЯЮ! ВЫ ПОЛУЧИЛИ НЕЙТРАЛЬНУЮ КОНЦОВКУ");
        } else {
            System.out.println("ГАНС УМЕР ОТ ХОЛОДА И ГОЛОДА");
        }
    }

    @Override
    public void act() {
        System.out.println(getName() + " прибывает в золотой карете");
    }

    @Override
    public void speak() {
        System.out.println(getName() + " говорит: 'Позови мне своего младшего ученика, великолепного Ганса, который служил у меня семь лет'");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Princess princess = (Princess) o;
        return statusLevel == princess.statusLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), statusLevel);
    }

    @Override
    public String toString() {
        return "Princess{" +
                "name='" + getName() + '\'' +
                ", statusLevel=" + statusLevel +
                '}';
    }
}

