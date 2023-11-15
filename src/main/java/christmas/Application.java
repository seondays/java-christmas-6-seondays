package christmas;

import christmas.controller.Controller;
import christmas.model.BenefitResultMaker;
import christmas.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        BenefitResultMaker stringMaker = new BenefitResultMaker();

        Controller controller = new Controller(stringMaker, inputView);
        controller.run();
    }
}