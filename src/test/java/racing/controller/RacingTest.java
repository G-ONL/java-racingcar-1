package racing.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingTest {
    List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = Arrays.asList(new Car("pobi"),new Car("sean"));
    }

    @Test
    void 차량이름_중복() {
        cars.add(new Car("pobi"));

        assertThrows(IllegalArgumentException.class, () -> {
            new Racing(cars, 3);
        });
    }

    @Test()
    void 이동횟수_음수() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Racing(cars, -1);
        });
    }
}
