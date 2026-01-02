package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;
import racingcar.domain.dto.Winners;

class CarsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 이름_중복_오류() {
        assertThatThrownBy(() -> Cars.from(List.of("가나", "가나")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NAME_DUPLICATION_ERROR.getErrorMessage());
    }

    @Test
    void 숫자에_따른_경주_결과() {
        Cars cars = Cars.from(List.of("가", "나", "다"));

        cars.raceRound(new ArrayList<>(List.of(MOVING_FORWARD, MOVING_FORWARD, STOP)));
        cars.raceRound(new ArrayList<>(List.of(MOVING_FORWARD, STOP, MOVING_FORWARD)));
        cars.raceRound(new ArrayList<>(List.of(MOVING_FORWARD, MOVING_FORWARD, STOP)));

        Map<String, Integer> roundResult = cars.getRoundResult();
        List<Integer> steps = roundResult.values().stream()
                .toList();
        List<Integer> expectedSteps = List.of(3, 2, 1);

        assertThat(steps).containsExactlyElementsOf(expectedSteps);
    }

    @Test
    void 숫자에_따른_단독_우승자_결과() {
        Cars cars = Cars.from(List.of("가", "나", "다"));

        cars.raceRound(new ArrayList<>(List.of(MOVING_FORWARD, MOVING_FORWARD, STOP)));
        cars.raceRound(new ArrayList<>(List.of(MOVING_FORWARD, STOP, MOVING_FORWARD)));
        cars.raceRound(new ArrayList<>(List.of(MOVING_FORWARD, MOVING_FORWARD, STOP)));

        Winners winners = cars.getWinners();

        assertThat(winners.winners()).containsExactly("가");
    }

    @Test
    void 숫자에_따른_공동_우승자_결과() {
        Cars cars = Cars.from(List.of("가", "나", "다"));

        cars.raceRound(new ArrayList<>(List.of(MOVING_FORWARD, MOVING_FORWARD, STOP)));
        cars.raceRound(new ArrayList<>(List.of(MOVING_FORWARD, STOP, MOVING_FORWARD)));
        cars.raceRound(new ArrayList<>(List.of(STOP, MOVING_FORWARD, STOP)));

        Winners winners = cars.getWinners();

        assertThat(winners.winners()).containsExactly("가", "나");
    }
}