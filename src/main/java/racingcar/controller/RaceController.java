package racingcar.controller;

import racingcar.model.domain.Cars;
import racingcar.model.domain.WinningCars;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private final RaceService service;

    public RaceController(RaceService service) {
        this.service = service;
    }

    public void run() {
        Cars cars = getCars();
        Integer round = getRound(cars);
        Cars finalCars = runRaceEveryRound(cars, round);
        showWinners(finalCars);
    }

    private Cars getCars() {
        OutputView.printCarNamesRequest();
        String carNames = InputView.readUserInput();
        return service.generateCars(carNames);
    }

    private Integer getRound(Cars cars) {
        OutputView.printRoundRequest();
        String round = InputView.readUserInput();
        return service.generateRound(round);
    }

    private Cars runRaceEveryRound(Cars cars, Integer round) {
        OutputView.printMessageBeforeRace();
        Cars prevRoundCars = cars;
        Cars nextRoundCars = cars;
        for (int i = 0; i < round; i++) {
            nextRoundCars = service.runRace(prevRoundCars);
            OutputView.printRace(nextRoundCars);
            prevRoundCars = nextRoundCars;
        }
        return nextRoundCars;
    }
}
