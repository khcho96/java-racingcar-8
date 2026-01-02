package racingcar.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class RandomNumberGenerator {

    public static List<Integer> generateNumbers(int count) {
        return new ArrayList<>(Stream.generate(() -> Randoms.pickNumberInRange(0, 9))
                .limit(count)
                .toList());
    }
}
