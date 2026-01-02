package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.constant.ErrorMessage;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = List.copyOf(cars);
    }

    public static Cars from(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            Car car = Car.from(carName);
            validateDuplication(cars, car);
            cars.add(car);
        }

        return new Cars(cars);
    }

    private static void validateDuplication(List<Car> cars, Car car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException(ErrorMessage.NAME_DUPLICATION_ERROR.getErrorMessage());
        }
    }
}
