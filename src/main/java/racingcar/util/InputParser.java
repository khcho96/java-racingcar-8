package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class InputParser {

    private static final String DELIMITER = ",";

    private InputParser() {
    }

    public static int parseRound(String rawInput) {
        rawInput = rawInput.strip();

        Validator.validateNumberFormat(rawInput);

        return NumberConvertor.convertToNumber(rawInput);
    }

    public static List<String> parseCarNames(String rawInput) {
        rawInput = rawInput.strip();

        Validator.validateCsvFormat(rawInput);

        return Stream.of(rawInput.split(DELIMITER))
                .map(String::strip)
                .toList();
    }
}
