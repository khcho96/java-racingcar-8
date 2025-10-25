package racingcar.model.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.ErrorMessage.CAR_NAME_LENGTH_ERROR;
import static racingcar.constant.ErrorMessage.INVALID_INPUT_ERROR;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @DisplayName("자동차 이름 공백 검증")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void validateCarNameNBlankTest(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_INPUT_ERROR.getErrorMessage());
    }

    @DisplayName("자동차 이름 길이 검증")
    @Test
    void validateCarNameLengthTest() {
        // given
        String carName = "jacobs";

        // when then
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_LENGTH_ERROR.getErrorMessage());
    }
}
