package racingcar.util;

public class Validator {

    public static void validateNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("유효하지 않은 값입니다.");
        }
    }
}
