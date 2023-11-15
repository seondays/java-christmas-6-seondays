package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.validator.InputValidator;

public class InputView {
    InputValidator inputValidator = new InputValidator();

    public String getInputDate() {
        String input = Console.readLine();
        inputValidator.validateInputDate(input);
        return input;
    }

    public String getInputMenu() {
        String input = Console.readLine();
        inputValidator.validateInputMenu(input);
        return input;
    }

    public void close() {
        Console.close();
    }
}
