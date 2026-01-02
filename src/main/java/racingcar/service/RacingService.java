package racingcar.service;

import java.util.List;
import racingcar.domain.Cars;

public class RacingService {

    private Cars cars;

    public void registerCar(List<String> carNames) {
        cars = Cars.from(carNames);
    }
}
