package racingcar.model.domain;

import static org.assertj.core.api.Assertions.assertThat;

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
        String expectedMessage = "[ERROR] 자동차 이름은 중복을 허용하지 않습니다.";

        // when then
        Assertions.assertThatThrownBy(() -> Cars.CarsFrom(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }
}
