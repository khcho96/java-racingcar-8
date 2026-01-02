package racingcar.domain;

public class RacingGame {

    private final Round round;

    public RacingGame(Round round) {
        this.round = round;
    }

    public static RacingGame from(int round) {
        return new RacingGame(Round.from(round));
    }
}
