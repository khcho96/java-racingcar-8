package racingcar.util;

import racingcar.constant.ErrorMessage;

public final class NumberConvertor {

    public static Integer convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.FORMAT_ERROR.getErrorMessage());
        }
    }
}
