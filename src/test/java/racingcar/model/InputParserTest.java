package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputParserTest {

    @DisplayName("자동차 이름 입력값이 공백이면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void carNamesInputIsBlankTest(String input) {
        // given
        String expectedMessage = "[ERROR] 유효하지 않은 입력값입니다.";

        // when then
        assertThatThrownBy(()->InputParser.carNamesInputParserFrom(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @DisplayName("시도할 횟수 입력값이 공백이면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void roundInputIsBlankTest(String input) {
        // given
        String expectedMessage = "[ERROR] 유효하지 않은 입력값입니다.";

        // when then
        assertThatThrownBy(()->InputParser.roundInputParserFrom(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @DisplayName("시도할 횟수 입력값이 자연수가 아니면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "a"})
    void roundInputIsNumberTest(String input) {
        // given
        String expectedMessage = "[ERROR] 시도할 횟수는 자연수만 가능합니다.";

        // when then
        assertThatThrownBy(()->InputParser.roundInputParserFrom(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @DisplayName("시도할 횟수 입력값이 최댓값을 초과하면 예외 발생")
    @Test
    void roundInputExceedMaxTest() {
        // given
        String input = "10001";
        String expectedMessage = "[ERROR] 시도할 횟수는 10,000 이하의 값만 가능합니다.";

        // when then
        assertThatThrownBy(()->InputParser.roundInputParserFrom(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @DisplayName("자동차 이름 쉼표로 분리")
    @ParameterizedTest
    @MethodSource("carNamesInputProvider")
    void getSplitCarNamesTest(String input, String[] splitCarNames) {
        // given
        InputParser inputParser = InputParser.carNamesInputParserFrom(input);

        // when
        List<String> splitCarNameList = inputParser.getSplitCarNames();

        // then
        assertThat(splitCarNameList).containsExactly(splitCarNames);
    }

    static Stream<Arguments> carNamesInputProvider() {
        return Stream.of(
                Arguments.of("a,b,c", new String[]{"a", "b", "c"}),
                Arguments.of("a,,b,c", new String[]{"a", "", "b", "c"}),
                Arguments.of(",a,b,c,", new String[]{"", "a", "b", "c"})
        );
    }

    @DisplayName("시도할 횟수 양수로 변환")
    @Test
    void getRoundTest() {
        // given
        InputParser inputParser = InputParser.roundInputParserFrom("1");

        // when
        Integer round = inputParser.getRound();

        // then
        assertThat(round).isEqualTo(1);
    }
}
