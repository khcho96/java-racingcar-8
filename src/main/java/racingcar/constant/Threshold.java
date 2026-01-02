package racingcar.constant;

import java.util.stream.Stream;

public enum Threshold {

    GO(4),
    STOP(0);

    private final int threshold;

    Threshold(int threshold) {
        this.threshold = threshold;
    }

    public static Threshold from(int number) {
        return Stream.of(values())
                .filter(threshold -> threshold.threshold <= number)
                .findFirst()
                .orElse(STOP);
    }
}
