package racingcar.generator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    void 랜덤_숫자_생성() {
        assertRandomNumberInRangeTest(() -> {
            List<Integer> numbers = RandomNumberGenerator.generateNumbers(5);

            assertThat(numbers).containsExactlyElementsOf(List.of(1, 2, 3, 4, 5));
        }, 1, 2, 3, 4, 5);
    }
}