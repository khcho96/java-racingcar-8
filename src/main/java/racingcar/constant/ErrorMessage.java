package racingcar.constant;

public enum ErrorMessage {

    FORMAT_ERROR("잘못된 형식입니다."),

    NAME_LENGTH_ERROR("이름은 5자 이하만 가능합니다."),
    NAME_DUPLICATION_ERROR("이름이 중복입니다.."),

    ROUND_ERROR("1 이상의 숫자를 입력해주세요.."),
    ;

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(Object... args) {
        return ERROR_MESSAGE_PREFIX + String.format(errorMessage, args);
    }
}
