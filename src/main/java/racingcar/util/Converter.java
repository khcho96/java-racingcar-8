package racingcar.util;

public class Converter {
    public static Integer convertStringToNumber(String input) {
        try {
            return Integer.parseUnsignedInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도할 횟수는 자연수만 가능합니다.");
        }
    }
}
