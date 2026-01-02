package racingcar.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

    public void raceRound(List<Integer> numbers) {
        for (Car car : cars) {
            car.race(numbers.getFirst());
        }
    }

    public int getCount() {
        return cars.size();
    }

    public Map<String, Integer> getRoundResult() {
        Map<String, Integer> result = new LinkedHashMap<>();
        for (Car car : cars) {
            result.put(car.getName(), car.getStep());
        }
        return Map.copyOf(result);
    }

    public Winners getWinners() {
        List<String> winners = new ArrayList<>();
        
        decideWinners(winners);
        
        return Winners.from(winners);
    }

    private void decideWinners(List<String> winners) {
        int maxStep = 0;
        for (Car car : cars) {
            if (car.getStep() > maxStep) {
                winners.clear();
                winners.add(car.getName());
                maxStep = car.getStep();
                continue;
            }

            if (car.getStep() == maxStep) {
                winners.add(car.getName());
            }
        }
    }
}
