package racingcar.model.domain;

import static racingcar.constant.Constant.RESULT_DELIMITER;

import java.util.ArrayList;
import java.util.List;

public class WinningCars {
    private final List<Car> winningCars;

    private WinningCars(List<Car> winningCars) {
        this.winningCars = List.copyOf(winningCars);
    }

    public static WinningCars winningCarsFrom(Cars cars) {
        List<Car> winningCars = cars.getWinningCars();
        return new WinningCars(winningCars);
    }

    public String getWinners() {
        List<String> winnerList = new ArrayList<>();
        for (Car winningCar : winningCars) {
            winningCar.addTo(winnerList);
        }
        return String.join(RESULT_DELIMITER, winnerList);
    }
}
