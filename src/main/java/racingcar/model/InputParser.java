package racingcar.model;

import static racingcar.constant.core.Constant.DELIMITER;

import java.util.List;
import java.util.stream.Stream;
import racingcar.util.Validator;

public class InputParser {

    private static InputParser inputParserObj;
    private String input;

    private InputParser(String input) {
        this.input = input.strip();
    }

    public static InputParser from(String input) {
        Validator.validateNullOrBlank(input);
        return new InputParser(input);
    }

    public List<String> getSplitCarNames() {
        return Stream.of(input.split(DELIMITER))
                .toList();
    }
}
