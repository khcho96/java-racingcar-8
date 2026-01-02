package racingcar.domain;

import racingcar.constant.ErrorMessage;

public class Round {

    private final int maxRound;
    private int currentRound;

    public Round(int maxRound) {
        this.maxRound = maxRound;
    }

    public static Round from(int round) {
        validateRound(round);
        return new Round(round);
    }

    private static void validateRound(int round) {
        if (round <= 0) {
            throw new IllegalArgumentException(ErrorMessage.ROUND_ERROR.getErrorMessage());
        }
    }
}
