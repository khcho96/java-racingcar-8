package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공동_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD
        );
    }

    @Test
    void 자동차_이름_형식_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi:java"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.FORMAT_ERROR.getErrorMessage())
        );
    }

    @Test
    void 자동차_이름_길이_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,abcdefg"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.NAME_LENGTH_ERROR.getErrorMessage())
        );
    }

    @Test
    void 자동차_이름_중복_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.NAME_DUPLICATION_ERROR.getErrorMessage())
        );
    }

    @Test
    void 시도횟수_형식_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jacob", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.FORMAT_ERROR.getErrorMessage())
        );
    }

    @Test
    void 시도횟수_범위_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jacob", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.ROUND_ERROR.getErrorMessage())
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
