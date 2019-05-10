package racing.model;

import java.util.Objects;

public class Car {
    private final static int FORWARD_NUMBER = 4;
    private final static int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    // Constructor for test code
    public Car(String name, int position) {
        if ("".equals(name) || name.length() > MAX_NAME_LENGTH || position < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if (number >= FORWARD_NUMBER) {
            position++;
        }
    }

    public boolean matchPosition(int position) {
        return this.position == position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
