package racingcar.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ThresholdTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 임계값_4_이상이면_GO_반환(int number) {
        assertThat(Threshold.from(number)).isEqualTo(Threshold.GO);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 임계값_4_미만이면_STOP_반환(int number) {
        assertThat(Threshold.from(number)).isEqualTo(Threshold.STOP);
    }
}