package racingcar.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StepTest {

    @Test
    void 이동_거리_증가_테스트() {
        Step step = Step.newInstance();

        assertThat(step.getStep()).isEqualTo(0);

        step.increaseStep();
        step.increaseStep();
        step.increaseStep();

        assertThat(step.getStep()).isEqualTo(3);
    }
}