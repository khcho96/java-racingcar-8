package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Nested;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.ErrorMessage.CAR_NAME_LENGTH_ERROR;
import static racingcar.constant.ErrorMessage.CAR_NAME_UNIQUE_ERROR;
import static racingcar.constant.ErrorMessage.INVALID_INPUT_ERROR;
import static racingcar.constant.ErrorMessage.INVALID_ROUND_ERROR;
import static racingcar.constant.ErrorMessage.ROUND_RANGE_ERROR;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @DisplayName("정상 입력 케이스")
    @Nested
    class Success {
        @DisplayName("단독 우승")
        @ParameterizedTest
        @MethodSource("soloWinningArgumentProvider")
        void soloWinningTest(Integer firstRandomNumber, Integer[] randomNumber, String carName, String round,
                             String result) {
            assertRandomNumberInRangeTest(
                    () -> {
                        run(carName, round);
                        assertThat(output()).contains(result);
                    },
                    firstRandomNumber, randomNumber
            );
        }

        static Stream<Arguments> soloWinningArgumentProvider() {
            return Stream.of(
                    Arguments.of(MOVING_FORWARD, new Integer[]{STOP},
                            "pobi,woni", "1", "pobi : -\nwoni : \n\n최종 우승자 : pobi"),
                    Arguments.of(MOVING_FORWARD, new Integer[]{STOP, MOVING_FORWARD, MOVING_FORWARD},
                            "pobi,woni", "2", "pobi : -\nwoni : \n\npobi : --\nwoni : -\n\n최종 우승자 : pobi"),
                    Arguments.of(MOVING_FORWARD, new Integer[]{STOP, STOP},
                            "pobi,woni,jacob", "1", "pobi : -\nwoni : \njacob : \n\n최종 우승자 : pobi")
            );
        }

        @DisplayName("공동 우승")
        @ParameterizedTest
        @MethodSource("jointWinningArgumentProvider")
        void jointWinningTest(Integer firstRandomNumber, Integer[] randomNumber, String carName, String round,
                              String result) {
            assertRandomNumberInRangeTest(
                    () -> {
                        run(carName, round);
                        assertThat(output()).contains(result);
                    },
                    firstRandomNumber, randomNumber
            );
        }

        static Stream<Arguments> jointWinningArgumentProvider() {
            return Stream.of(
                    Arguments.of(MOVING_FORWARD, new Integer[]{MOVING_FORWARD},
                            "pobi,woni", "1", "pobi : -\nwoni : -\n\n최종 우승자 : pobi, woni"),
                    Arguments.of(MOVING_FORWARD, new Integer[]{MOVING_FORWARD},
                            "pobi,woni,jacob", "2",
                            "pobi : -\nwoni : -\njacob : -\n\npobi : --\nwoni : --\njacob : --\n\n최종 우승자 : pobi, woni, jacob")
            );
        }

        @DisplayName("다양한 유형의 자동차 이름")
        @ParameterizedTest
        @MethodSource("variousNamesArgumentProvider")
        void variousNamesTest(Integer firstRandomNumber, Integer[] randomNumber, String carName, String round,
                              String result) {
            assertRandomNumberInRangeTest(
                    () -> {
                        run(carName, round);
                        assertThat(output()).contains(result);
                    },
                    firstRandomNumber, randomNumber
            );
        }

        static Stream<Arguments> variousNamesArgumentProvider() {
            return Stream.of(
                    Arguments.of(MOVING_FORWARD, new Integer[]{STOP},
                            "123,jacob", "1", "123 : -\njacob : \n\n최종 우승자 : 123"),
                    Arguments.of(MOVING_FORWARD, new Integer[]{STOP},
                            "*!,jacob", "1", "*! : -\njacob : \n\n최종 우승자 : *!"),
                    Arguments.of(MOVING_FORWARD, new Integer[]{STOP},
                            "a1!,jacob", "1", "a1! : -\njacob : \n\n최종 우승자 : a1")
                    );
        }

        @DisplayName("자동차 이름 입력값 공백 처리")
        @ParameterizedTest
        @MethodSource("carNameSpaceArgumentProvider")
        void carNameSpaceTest(Integer firstRandomNumber, Integer[] randomNumber, String carName, String round,
                              String result) {
            assertRandomNumberInRangeTest(
                    () -> {
                        run(carName, round);
                        assertThat(output()).contains(result);
                    },
                    firstRandomNumber, randomNumber
            );
        }

        static Stream<Arguments> carNameSpaceArgumentProvider() {
            return Stream.of(
                    Arguments.of(MOVING_FORWARD, new Integer[]{STOP},
                            "  pobi,woni  ", "1", "pobi : -\nwoni : \n\n최종 우승자 : pobi"),
                    Arguments.of(MOVING_FORWARD, new Integer[]{STOP},
                            " pobi  ,  woni ", "1", "pobi : -\nwoni : \n\n최종 우승자 : pobi"),
                    Arguments.of(MOVING_FORWARD, new Integer[]{STOP},
                            "po bi,wo ni", "1", "po bi : -\nwo ni : \n\n최종 우승자 : po bi")
            );
        }
    }

    @DisplayName("예외 발생 케이스")
    @Nested
    class Failure {
        @DisplayName("유효하지 않은 입력 오류")
        @ParameterizedTest
        @MethodSource("invalidInputArgumentProvider")
        void invalidInputErrorTest(String carNames, String round) {
            assertThatThrownBy(() -> runException(carNames, round))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INVALID_INPUT_ERROR.getErrorMessage());
        }

        static Stream<Arguments> invalidInputArgumentProvider() {
            return Stream.of(
                    Arguments.of("", "1"),
                    Arguments.of(" ", "1"),
                    Arguments.of("pobi,,woni", "1"),
                    Arguments.of(",pobi,woni,", "1"),
                    Arguments.of("pobi,woni", ""),
                    Arguments.of("pobi,woni", " ")
            );
        }

        @DisplayName("자동차 이름 길이 오류")
        @ParameterizedTest
        @MethodSource("carNameLengthArgumentProvider")
        void carNameLengthErrorTest(String carNames, String round) {
            assertThatThrownBy(() -> runException(carNames, round))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CAR_NAME_LENGTH_ERROR.getErrorMessage());
        }

        static Stream<Arguments> carNameLengthArgumentProvider() {
            return Stream.of(
                    Arguments.of("pobi,jacob,steven", "1"),
                    Arguments.of("pobi,ab cde", "1")
            );
        }

        @DisplayName("자동차 이름 중복 오류")
        @ParameterizedTest
        @MethodSource("carNameUniqueArgumentProvider")
        void carNameUniqueErrorTest(String carNames, String round) {
            assertThatThrownBy(() -> runException(carNames, round))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CAR_NAME_UNIQUE_ERROR.getErrorMessage());
        }

        static Stream<Arguments> carNameUniqueArgumentProvider() {
            return Stream.of(
                    Arguments.of("pobi,jacob,jacob", "1")
            );
        }

        @DisplayName("시도할 횟수 형식 오류")
        @ParameterizedTest
        @MethodSource("invalidRoundArgumentProvider")
        void invalidRoundErrorTest(String carNames, String round) {
            assertThatThrownBy(() -> runException(carNames, round))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INVALID_ROUND_ERROR.getErrorMessage());
        }

        static Stream<Arguments> invalidRoundArgumentProvider() {
            return Stream.of(
                    Arguments.of("pobi,jacob", "a"),
                    Arguments.of("pobi,jacob", "-1"),
                    Arguments.of("pobi,jacob", "0"),
                    Arguments.of("pobi,jacob", "1,5")
            );
        }

        @DisplayName("시도할 횟수 최댓값 초과 오류")
        @ParameterizedTest
        @MethodSource("roundExceedMaxArgumentProvider")
        void roundExceedMaxErrorTest(String carNames, String round) {
            assertThatThrownBy(() -> runException(carNames, round))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ROUND_RANGE_ERROR.getErrorMessage());
        }

        static Stream<Arguments> roundExceedMaxArgumentProvider() {
            return Stream.of(
                    Arguments.of("pobi,jacob", "10001")
            );
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
