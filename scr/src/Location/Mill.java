import java.util.Objects;

public class Mill extends Location {
    private int minCleanLevel;

    public Mill(int minCleanLevel) {
        this.minCleanLevel = minCleanLevel;
    }

    public Mill() {
        this.minCleanLevel = 40;
    }

    public int getMinCleanLevel() {
        return minCleanLevel;
    }

    public void setMinCleanLevel(int minCleanLevel) {
        this.minCleanLevel = minCleanLevel;
    }

    @Override
    public void enter(Character c) {
        System.out.println(c.getName() + " входит в мельницу");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mill mill = (Mill) o;
        return minCleanLevel == mill.minCleanLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minCleanLevel);
    }

    @Override
    public String toString() {
        return "Mill{" +
                "minCleanLevel=" + minCleanLevel +
                '}';
    }
}

