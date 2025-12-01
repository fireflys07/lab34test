package Character;

import java.util.Objects;

public abstract class Character {
    private String name;
    private Status status;
    private CharacterAttributes attributes;

    public Character(String name, Status status, CharacterAttributes attributes) {
        this.name = name;
        this.status = status;
        this.attributes = attributes;
    }

    public Character(String name) {
        this.name = name;
        this.status = Status.COMMON;
        this.attributes = new CharacterAttributes(5, 5, 5);
    }

    public abstract void act();

    public abstract void speak();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public CharacterAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(CharacterAttributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(name, character.name) && status == character.status && Objects.equals(attributes, character.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, status, attributes);
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", status=" + status +
                ", attributes=" + attributes +
                '}';
    }
}
