package racingcar.view;

import java.util.List;
import racingcar.model.domain.Car;
import racingcar.model.domain.Cars;
import racingcar.model.domain.WinningCars;

public class OutputView {
    private static final String CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_REQUEST_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String STEP = "-";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void printCarNamesRequest() {
        System.out.println(CAR_NAMES_REQUEST_MESSAGE);
    }

    public static void printRoundRequest() {
        System.out.println(ROUND_REQUEST_MESSAGE);
    }

    public static void printMessageBeforeRace() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRace(Cars cars) {
        List<Car> carList = cars.getCars();
        for (Car car : carList) {
            System.out.println(car.getCurrentRace(STEP));
        }
        System.out.println();
    }
}
