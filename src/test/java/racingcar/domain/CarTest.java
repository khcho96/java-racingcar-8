package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.ErrorMessage;

class CarTest {

    @Test
    void 이름_길이_오류() {
        assertThatThrownBy(() -> Car.from("가나다라마바"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NAME_LENGTH_ERROR.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"가", "가나", "가나다", "가나다라", "가나다라마"})
    void 이름_길이_정상(String name) {
        Car.from(name);
    }

    @Test
    void 초기_이동_거리_0() {
        Car car = Car.from("가나다라마");
        assertThat(car.getStep()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 7, 9})
    void 숫자가_4_이상이면_전진(int number) {
        Car car = Car.from("가나");
        car.race(number);
        car.race(number);
        car.race(number);
        assertThat(car.getStep()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 숫자가_4_미만이면_정지(int number) {
        Car car = Car.from("가나");
        car.race(number);
        car.race(number);
        car.race(number);
        assertThat(car.getStep()).isEqualTo(0);
    }
}