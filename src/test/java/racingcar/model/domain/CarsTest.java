package racingcar.model.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.ErrorMessage.CAR_NAME_UNIQUE_ERROR;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @DisplayName("중복 예외 발생")
    @Test
    void validateUniqueCarNameTest() {
        // given
        List<String> carNames = List.of("a", "b", "a");

        // when then
        Assertions.assertThatThrownBy(() -> Cars.carsFrom(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_UNIQUE_ERROR.getErrorMessage());
    }

    @DisplayName("자동차 리스트 생성")
    @Test
    void CarsFromTest() {
        // given
        List<String> carNames = List.of("a", "b", "c");

        // when
        Cars cars = Cars.carsFrom(carNames);

        // then
        assertThat(cars).isInstanceOf(Cars.class);
    }
}
