package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.InputValidator;

public class InputView {
    InputValidator inputValidator = new InputValidator();

    //날짜 입력 받기
    public String getInputDate() {
        String input = Console.readLine();
        inputValidator.validateInputDate(input);
        return input;
    }

    //메뉴 입력 받기
    public String getInputMenu() {
        String input = Console.readLine();
        inputValidator.validateInputMenu(input);
        return input;
    }

    public void close() {
        Console.close();
    }
}
