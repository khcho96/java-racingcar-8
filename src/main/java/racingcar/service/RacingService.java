package racingcar.service;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;

public class RacingService {

    private Cars cars;
    private RacingGame racingGame;

    public void registerCar(List<String> carNames) {
        cars = Cars.from(carNames);
    }

    public void registerRound(int round) {
        racingGame = RacingGame.from(round);
    }
}
