package racingcar.domain.dto;

import java.util.Map;

public record RoundResult(Map<String, Integer> result) {

    public static RoundResult from(Map<String, Integer> cars) {
        return new RoundResult(cars);
    }
}
