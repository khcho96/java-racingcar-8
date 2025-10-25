package racingcar.service;

import java.util.List;
import racingcar.model.InputParser;
import racingcar.model.domain.Cars;

public class RaceService {
    public Cars generateCars(String carNames) {
        InputParser inputParser = InputParser.carNamesInputParserFrom(carNames);
        List<String> splitCarNames = inputParser.getSplitCarNames();
        return Cars.CarsFrom(splitCarNames);
    }
}
