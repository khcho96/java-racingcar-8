package racingcar.domain.vo;

public class Step {

    private int step;

    public static Step newInstance() {
        return new Step();
    }

    public void increaseStep() {
        step++;
    }

    public int getStep() {
        return step;
    }
}
