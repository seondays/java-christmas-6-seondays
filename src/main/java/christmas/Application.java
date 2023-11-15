package christmas;

import christmas.controller.Controller;
import christmas.model.StringMaker;
import christmas.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        StringMaker stringMaker = new StringMaker();

        Controller controller = new Controller(stringMaker, inputView);
        controller.run();
    }
}