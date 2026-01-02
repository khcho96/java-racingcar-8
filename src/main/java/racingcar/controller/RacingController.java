package racingcar.controller;

import java.util.List;
import racingcar.domain.dto.RoundResult;
import racingcar.service.RacingService;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

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
        racingService.registerRound(round);

        OutputView.printResultIntro();
        while (!racingService.gameOver()) {
            RoundResult roundResult = racingService.race();

            OutputView.printRound(roundResult);
        }
    }
}

