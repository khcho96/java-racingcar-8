package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputParserTest {

    @DisplayName("입력값이 공백이면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void InputValueIsBlankTest(String input) {
        // given
        String expectedMessage = "유효하지 않은 값입니다.";

        // when then
        assertThatThrownBy(()->InputParser.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @DisplayName("자동차 이름 쉼표로 분리")
    @ParameterizedTest
    @MethodSource("argumentProvider")
    void getSplitCarNamesTest(String input, String[] splitCarNames) {
        // given
        InputParser inputParser = InputParser.from(input);

        // when
        List<String> splitCarNameList = inputParser.getSplitCarNames();

        // then
        assertThat(splitCarNameList).containsExactly(splitCarNames);
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
                Arguments.of("a,b,c", new String[]{"a", "b", "c"}),
                Arguments.of("a,,b,c", new String[]{"a", "", "b", "c"}),
                Arguments.of(",a,b,c,", new String[]{"", "a", "b", "c"})
        );
    }
}
