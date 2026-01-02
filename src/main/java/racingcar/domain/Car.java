package racingcar.domain;

import java.util.Objects;
import racingcar.constant.ErrorMessage;
import racingcar.constant.Threshold;
import racingcar.domain.vo.Step;

public class Car {

    private final String name;
    private final Step step;

    public Car(String name, Step step) {
        this.name = name;
        this.step = step;
    }

    public static Car from(String carName) {
        validateNameLength(carName);
        return new Car(carName, Step.newInstance());
    }

    private static void validateNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_ERROR.getErrorMessage());
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car car = (Car) object;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public void race(int number) {
        if (Threshold.from(number).equals(Threshold.GO)) {
            step.increaseStep();
        }
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step.getStep();
    }
}
