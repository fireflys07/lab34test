package Character;

import java.util.Objects;

public class Miller extends Character {
    private int wealth;

    public Miller(String name, int wealth, Status status, CharacterAttributes attributes) {
        super(name, status, attributes);
        this.wealth = wealth;
    }

    public Miller(String name, int wealth) {
        super(name, Status.COMMON, new CharacterAttributes(2, 3, 1));
        this.wealth = wealth;
    }

    public Miller() {
        super("Мельник", Status.COMMON, new CharacterAttributes(2, 3, 1));
        this.wealth = 100;
    }

    public int getWealth() {
        return wealth;
    }

    public void setWealth(int wealth) {
        this.wealth = wealth;
    }

    public void validateAppearance(Character character) throws InvalidAppearanceException {
        if (character instanceof Gans) {
            Gans gans = (Gans) character;
            if (gans.getDirtLevel() > 40) {
                throw new InvalidAppearanceException("Персонаж слишком грязный для чистой мельницы. Уровень грязи: " + gans.getDirtLevel());
            }
        }
    }

    @Override
    public void act() {
        System.out.println(getName() + " работает на мельнице");
    }

    @Override
    public void speak() {
        System.out.println(getName() + " говорит: 'Как ты мог заявиться на мою чистую мельницу в своих грязных лохмотьях? Убирайся вон!'");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Miller miller = (Miller) o;
        return wealth == miller.wealth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wealth);
    }

    @Override
    public String toString() {
        return "Miller{" +
                "name='" + getName() + '\'' +
                ", wealth=" + wealth +
                '}';
    }
}

