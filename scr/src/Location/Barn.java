package Location;

import Character.Character;
import java.util.Objects;

public class Barn extends Location {
    private int maxCapacity;
    private int occupants;

    public Barn(int maxCapacity, int occupants) {
        this.maxCapacity = maxCapacity;
        this.occupants = occupants;
    }

    public Barn(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.occupants = 0;
    }

    public Barn() {
        this.maxCapacity = 5;
        this.occupants = 0;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getOccupants() {
        return occupants;
    }

    public void setOccupants(int occupants) {
        this.occupants = occupants;
    }

    @Override
    public void enter(Character c) throws OvercrowdedBarnException {
        if (occupants >= maxCapacity) {
            throw new OvercrowdedBarnException("Амбар переполнен. Текущее количество: " + occupants + ", максимум: " + maxCapacity);
        }
        occupants++;
        System.out.println(c.getName() + " входит в амбар. Текущее количество жильцов: " + occupants);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Barn barn = (Barn) o;
        return maxCapacity == barn.maxCapacity && occupants == barn.occupants;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxCapacity, occupants);
    }

    @Override
    public String toString() {
        return "Barn{" +
                "maxCapacity=" + maxCapacity +
                ", occupants=" + occupants +
                '}';
    }
}

