package racingcar.util;

import java.util.List;

public class Validator {

    public static void validateNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력값입니다.");
        }
    }

    public static void validateCarNameLength(String CarName) {
        if (CarName.strip().length() > 5) {
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
}
