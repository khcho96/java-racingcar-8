package racingcar.model.domain;

import racingcar.util.Validator;

public class Car {

    private final String name;
    private int step;

    public Car(String name) {
        Validator.validateNullOrBlank(name);
        Validator.validateCarNameLength(name);
        this.name = name.strip();
    }
}
