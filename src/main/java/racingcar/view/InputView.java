package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputView {

    public static String readUserInput() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }
}
