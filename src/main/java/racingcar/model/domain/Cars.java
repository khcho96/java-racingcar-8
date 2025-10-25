package racingcar.model.domain;

import java.util.List;
import racingcar.util.Validator;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars CarsFrom(List<String> carNames) {
        Validator.validateUniqueCarName(carNames);
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Cars conductRound() {
        for (Car car : cars) {
            car.moveOrStay();
        }

        return this;
    }

    public List<Car> getWinningCars() {
        Integer maxStep = getMaxStep();
        return cars.stream()
                .filter(car -> car.isWinner(maxStep))
                .toList();
    }

    public Integer getMaxStep() {
        Integer maxStep = 0;
        for (Car car : cars) {
            maxStep = car.getStepGreaterThan(maxStep);
        }
        return maxStep;
    }
}
