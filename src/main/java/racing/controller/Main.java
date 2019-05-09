package racing.controller;

import racing.model.Car;
import racing.model.Winner;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = makeCarList(InputView.carName());
        int count = InputView.gameCount();

        Racing racing = new Racing(cars, count);
        racing.run();

        Winner winner = new Winner(cars);
        OutputView.print(winner);
    }

    private static List<Car> makeCarList(String carNames) {
        String[] carNameArray = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNameArray.length; i++) {
            cars.add(new Car(carNameArray[i]));
        }
        return cars;
    }
}
