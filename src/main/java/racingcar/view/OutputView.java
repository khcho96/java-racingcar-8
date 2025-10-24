package racingcar.view;

public class OutputView {
    private static final String CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_REQUEST_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static void printCarNamesRequest() {
        System.out.println(CAR_NAMES_REQUEST_MESSAGE);
    }

    public static void printRoundRequest() {
        System.out.println(ROUND_REQUEST_MESSAGE);
    }
}
