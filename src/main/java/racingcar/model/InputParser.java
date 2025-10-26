package racingcar.model;

import static racingcar.constant.Constant.DELIMITER;

import java.util.List;
import racingcar.util.Converter;
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

    public static InputParser roundInputParserFrom(String input) {
        Validator.validateNullOrBlank(input);
        Validator.validateNumber(input);
        Validator.validateExceedMax(input);
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
        return List.of(input.split(DELIMITER));
    }

    public Integer getRound() {
        return Converter.convertStringToNumber(input);
    }
}
