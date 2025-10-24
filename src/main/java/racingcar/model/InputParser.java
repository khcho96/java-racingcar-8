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

    public static InputParser carNamesInputParserFrom(String input) {
        Validator.validateNullOrBlank(input);
        return getInputParser(input);
    }

    public static InputParser RoundInputParserFrom(String input) {
        Validator.validateNullOrBlank(input);
        return getInputParser(input);
    }

    private static InputParser getInputParser(String input) {
        if (inputParserObj != null) {
            inputParserObj.input = input;
            return inputParserObj;
        }

        inputParserObj = new InputParser(input);
        return inputParserObj;
    }

    public List<String> getSplitCarNames() {
        return Stream.of(input.split(DELIMITER))
                .toList();
    }
}
