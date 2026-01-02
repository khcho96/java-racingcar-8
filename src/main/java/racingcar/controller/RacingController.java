package racingcar.controller;

import java.util.List;
import racingcar.service.RacingService;
import racingcar.util.InputParser;
import racingcar.view.InputView;

public class RacingController {

    private final RacingService racingService;

    public RacingController(RacingService racingService) {
        this.racingService = racingService;
    }

    public void run() {
        String readCarNames = InputView.readCarNames();
        List<String> carNames = InputParser.parseCarNames(readCarNames);
        racingService.registerCar(carNames);

        String readRound = InputView.readRound();
        int round = InputParser.parseRound(readRound);
        //racingService.registerRound(round);
    }

}

