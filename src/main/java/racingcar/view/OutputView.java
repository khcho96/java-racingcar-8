package racingcar.view;

import java.util.Map.Entry;
import racingcar.domain.dto.Winners;
import racingcar.domain.dto.RoundResult;

public class OutputView {

    private OutputView() {
    }

    public static void printResultIntro() {
        System.out.println("\n실행 결과");
    }

    public static void printRound(RoundResult roundResult) {
        for (Entry<String, Integer> car : roundResult.result().entrySet()) {
            String name = car.getKey();
            int step = car.getValue();
            System.out.println(name + " : " + "-".repeat(step));
        }
        System.out.println();
    }

    public static void printWinners(Winners winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners.winners()));
    }
}
