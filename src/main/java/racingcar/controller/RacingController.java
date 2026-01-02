package racingcar.controller;

import java.util.List;
import racingcar.domain.dto.Winners;
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
        registerCars();
        registerRound();

        playEachRound();
        printFinalWinners();
    }

    private void printFinalWinners() {
        Winners winners = racingService.getWinners();
        OutputView.printWinners(winners);
    }

    private void playEachRound() {
        OutputView.printResultIntro();
        while (!racingService.gameOver()) {
            RoundResult roundResult = racingService.race();

            OutputView.printRound(roundResult);
        }
    }

    private void registerRound() {
        String readRound = InputView.readRound();
        int round = InputParser.parseRound(readRound);
        racingService.registerRound(round);
    }

    private void registerCars() {
        String readCarNames = InputView.readCarNames();
        List<String> carNames = InputParser.parseCarNames(readCarNames);
        racingService.registerCar(carNames);
    }
}

