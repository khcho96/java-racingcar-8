package racingcar.service;

import java.util.List;
import racingcar.model.InputParser;
import racingcar.model.domain.Cars;
import racingcar.model.domain.WinningCars;

public class RaceService {
    public Cars generateCars(String carNames) {
        InputParser inputParser = InputParser.carNamesInputParserFrom(carNames);
        List<String> splitCarNames = inputParser.getSplitCarNames();
        return Cars.carsFrom(splitCarNames);
    }

    public Integer generateRound(String round) {
        InputParser inputParser = InputParser.roundInputParserFrom(round);
        return inputParser.getRound();
    }

    public Cars runRace(Cars cars) {
        return cars.conductRound();
    }

    public WinningCars decideWinners(Cars cars) {
        return WinningCars.winningCarsFrom(cars);
    }
}
