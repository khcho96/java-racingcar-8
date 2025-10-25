package racingcar.util;

import static racingcar.constant.Constant.MAX_CAR_NAME_LENGTH;
import static racingcar.constant.Constant.MAX_ROUND;
import static racingcar.constant.Constant.NUMBER_PATTERN;
import static racingcar.constant.ErrorMessage.CAR_NAME_LENGTH_ERROR;
import static racingcar.constant.ErrorMessage.CAR_NAME_UNIQUE_ERROR;
import static racingcar.constant.ErrorMessage.INVALID_ERROR;
import static racingcar.constant.ErrorMessage.INVALID_ROUND_ERROR;
import static racingcar.constant.ErrorMessage.ROUND_RANGE_ERROR;

import java.util.List;

public class Validator {

    public static void validateNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_ERROR.getErrorMessage());
        }
    }

    public static void validateCarNameLength(String CarName) {
        if (CarName.strip().length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR.getErrorMessage());
        }
    }

    public static void validateUniqueCarName(List<String> carNames) {
        int preLength = carNames.size();
        int distinctLength = carNames.stream()
                .map(String::strip)
                .distinct()
                .toList()
                .size();

        if (preLength != distinctLength) {
            throw new IllegalArgumentException(CAR_NAME_UNIQUE_ERROR.getErrorMessage());
        }
    }

    public static void validateNumber(String input) {
        if (!input.strip().matches(NUMBER_PATTERN) || input.strip().equals("0")) {
            throw new IllegalArgumentException(INVALID_ROUND_ERROR.getErrorMessage());
        }
    }

    public static void validateExceedMax(String input) {
        int round = Converter.convertStringToNumber(input);
        if (round > MAX_ROUND) {
            throw  new IllegalArgumentException(ROUND_RANGE_ERROR.getErrorMessage());
        }
    }
}
