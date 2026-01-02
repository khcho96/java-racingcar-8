package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void 시도횟수만큼_경주진행하면_게임종료() {
        Cars cars = Cars.from(List.of("가", "나", "다"));
        RacingGame racingGame = RacingGame.from(3);

        racingGame.race(cars);
        racingGame.race(cars);
        racingGame.race(cars);

        assertThat(racingGame.gameOver()).isTrue();
    }

    @Test
    void 시도횟수만큼_경주를_진행하지_않았으면_게임_미종료() {
        Cars cars = Cars.from(List.of("가", "나", "다"));
        RacingGame racingGame = RacingGame.from(3);

        racingGame.race(cars);
        racingGame.race(cars);

        assertThat(racingGame.gameOver()).isFalse();
    }
}