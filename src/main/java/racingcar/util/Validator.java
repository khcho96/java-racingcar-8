package racingcar.util;

import static racingcar.constant.Constant.MAX_CAR_NAME_LENGTH;
import static racingcar.constant.Constant.MAX_ROUND;
import static racingcar.constant.Constant.NUMBER_PATTERN;

import java.util.List;

public class Validator {

    public static void validateNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력값입니다.");
        }
    }

    public static void validateCarNameLength(String CarName) {
        if (CarName.strip().length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름의 길이는 최대 5입니다.");
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
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복을 허용하지 않습니다.");
        }
    }

    public static void validateNumber(String input) {
        if (!input.strip().matches(NUMBER_PATTERN) || input.strip().equals("0")) {
            throw new IllegalArgumentException("[ERROR] 시도할 횟수는 자연수만 가능합니다.");
        }
    }

    public static void validateExceedMax(String input) {
        int round = Converter.convertStringToNumber(input);
        if (round > MAX_ROUND) {
            throw  new IllegalArgumentException("[ERROR] 시도할 횟수는 10,000 이하의 값만 가능합니다.");
        }
    }
}
