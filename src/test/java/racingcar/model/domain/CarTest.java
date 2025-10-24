package racingcar.model.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @DisplayName("자동차 이름 공백 검증")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void validateCarNameNBlankTest(String carName) {
        // given
        String expectedMessage = "[ERROR] 유효하지 않은 입력값입니다.";

        // when then
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @DisplayName("자동차 이름 길이 검증")
    @Test
    void validateCarNameLengthTest() {
        // given
        String carName = "jacobs";
        String expectedMessage = "[ERROR] 자동차 이름의 길이는 최대 5입니다.";

        // when then
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }
}
