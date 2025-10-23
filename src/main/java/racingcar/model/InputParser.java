package racingcar.model;

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
}
