package racingcar.constant;

public enum ErrorMessage {
    INVALID_ERROR("[ERROR] 유효하지 않은 입력값입니다."),
    CAR_NAME_LENGTH_ERROR("[ERROR] 자동차 이름의 길이는 최대 5입니다."),
    CAR_NAME_UNIQUE_ERROR("[ERROR] 자동차 이름은 중복을 허용하지 않습니다."),
    INVALID_ROUND_ERROR("[ERROR] 시도할 횟수는 자연수만 가능합니다."),
    ROUND_RANGE_ERROR("[ERROR] 시도할 횟수는 10,000 이하의 값만 가능합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
