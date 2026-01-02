package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @Test
    void 자동차_이름_입력_파싱() {
        List<String> names = InputParser.parseCarNames("  가 , 나, 다 ");

        assertThat(names).containsExactly("가", "나", "다");
    }

    @Test
    void 시도_횟수_입력_파싱() {
        int round = InputParser.parseRound(" 5  ");

        assertThat(round).isEqualTo(5);
    }
}