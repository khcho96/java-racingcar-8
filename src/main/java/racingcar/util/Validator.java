package racingcar.util;

import racingcar.constant.ErrorMessage;

public final class Validator {

    private static final String CSV_FORMAT = "^[가-힣a-zA-Z\\s]+ *(, *[가-힣a-zA-Z\\s]+ *)*$";
    private static final String NUMBER_FORMAT = "\\d+";

    private Validator() {}

    public static void validateCsvFormat(String rawInput) {
        if (!rawInput.matches(CSV_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.FORMAT_ERROR.getErrorMessage());
        }
    }

    public static void validateNumberFormat(String rawInput) {
        if (!rawInput.matches(NUMBER_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.FORMAT_ERROR.getErrorMessage());
        }
    }
}
