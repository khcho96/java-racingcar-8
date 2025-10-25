package racingcar.model.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.util.Validator;

public class Car {

    private final String name;
    private int step;

    public Car(String name) {
        Validator.validateNullOrBlank(name);
        Validator.validateCarNameLength(name);
        this.name = name.strip();
    }

    public void moveOrStay() {
        if (generateRandomNumber() >= 4) {
            move();
        }
    }

    private void move() {
        step++;
    }

    private Integer generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public String getCurrentRace(String step) {
        return name + " : " + step.repeat(this.step);
    }
}
