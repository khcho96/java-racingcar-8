package racingcar.util;

import static racingcar.constant.ErrorMessage.INVALID_ROUND_ERROR;

public class Converter {
    public static Integer convertStringToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ROUND_ERROR.getErrorMessage());
        }
    }
}
