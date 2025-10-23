package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputParserTest {

    @DisplayName("입력값이 공백이면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void InputValueIsBlank(String input) {
        // given
        String expectedMessage = "유효하지 않은 값입니다.";

        // when then
        assertThatThrownBy(()->InputParser.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }
}
