package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;

class RoundTest {

    @Test
    void 라운드_입력이_1_미만이면_오류() {
        assertThatThrownBy(() -> Round.from(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ROUND_ERROR.getErrorMessage());
    }

    @Test
    void 현재_라운드가_시도횟수와_같으면_게임종료() {
        Round round = Round.from(3);

        round.raceRound();
        round.raceRound();
        round.raceRound();

        assertThat(round.gameOver()).isTrue();
    }

    @Test
    void 현재_라운드가_시도횟수와_다르면_게임_미종료() {
        Round round = Round.from(3);

        round.raceRound();
        round.raceRound();

        assertThat(round.gameOver()).isFalse();
    }
}