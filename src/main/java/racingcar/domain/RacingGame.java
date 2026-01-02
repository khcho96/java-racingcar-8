package racingcar.domain;

import racingcar.generator.RandomNumberGenerator;

public class RacingGame {

    private final Round round;

    public RacingGame(Round round) {
        this.round = round;
    }

    public static RacingGame from(int round) {
        return new RacingGame(Round.from(round));
    }

    public boolean gameOver() {
        return round.gameOver();
    }

    public void race(Cars cars) {
        round.raceRound();

        cars.raceRound(RandomNumberGenerator.generateNumbers(cars.getCount()));
    }
}
