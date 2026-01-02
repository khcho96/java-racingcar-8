package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;

class ValidatorTest {

    @Test
    void 쉼표_구분_입력_검증_통과() {
        Validator.validateCsvFormat("가,나,다");
    }

    @Test
    void 쉼표_구분_입력_검증_오류() {
        assertThatThrownBy(() -> Validator.validateCsvFormat("가:나"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.FORMAT_ERROR.getErrorMessage());
    }

    @Test
    void 숫자_입력_검증_통과() {
        Validator.validateNumberFormat("1");
    }

    @Test
    void 숫자_입력_검증_오류() {
        assertThatThrownBy(() -> Validator.validateNumberFormat("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.FORMAT_ERROR.getErrorMessage());
    }
}