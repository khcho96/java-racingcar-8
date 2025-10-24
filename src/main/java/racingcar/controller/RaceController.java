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
}
