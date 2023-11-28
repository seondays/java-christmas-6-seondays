package christmas.controller;

import christmas.model.Date;
import christmas.model.DiscountProcessor;
import christmas.utils.constant.Badge;
import christmas.model.Gift;
import christmas.utils.constant.Menu;
import christmas.model.RestaurantWaiter;
import christmas.model.BenefitResultMaker;
import christmas.utils.string.Parser;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;
import java.util.Map;

public class Controller {
    private final BenefitResultMaker benefitResultMaker;
    private final InputView inputView;
    private final boolean isInputIncomplete = true;
    private Map<Menu, Integer> orderedMenu;
    private int beforeDiscountCost;
    private Date date;

    public Controller(BenefitResultMaker benefitResultMaker, InputView inputView) {
        this.benefitResultMaker = benefitResultMaker;
        this.inputView = inputView;
    }

    public void run() {
        orderProcess();
        OutputView.printBeforeDiscountCost(beforeDiscountCost);
        DiscountProcessor discountProcessor = new DiscountProcessor(beforeDiscountCost, date, orderedMenu,
                benefitResultMaker);
        discountProcessor.addGiftCost(giftEventResult());
        discountProcessor.start();
        printBenefitResult(discountProcessor);
        inputView.close();
    }

    private void orderProcess() {
        OutputView.printInputDateMessage();
        date = new Date(getInputDate());
        OutputView.printInputMenuMessage();
        orderedMenu = getMenu();
        OutputView.printDayInformation(date.getDay());
        OutputView.printMenu(orderedMenu);
    }

    private void printBenefitResult(DiscountProcessor discountProcessor) {
        OutputView.printBenefitInformation(benefitResultMaker.getBenefitResult());
        OutputView.printBenefitCost(discountProcessor.getDiscountAmount());
        OutputView.printPaymentCost(discountProcessor.getDiscountCost());
        OutputView.printBadgeInformation(Badge.getBadge(discountProcessor.getDiscountAmount()));
    }

    private int giftEventResult() {
        Gift gift = new Gift(beforeDiscountCost);
        OutputView.printGift(gift.toString());
        benefitResultMaker.addGiftString(gift.getGiftPrice());
        return gift.getGiftPrice();
    }

    // supplier 학습 후 적용해보자
    private int getInputDate() {
        while (isInputIncomplete) {
            try {
                return Parser.parseStringToInt(inputView.getInputDate());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Map<Menu, Integer> getMenu() {
        while (isInputIncomplete) {
            try {
                List<String> input = Parser.splitInput(inputView.getInputMenu());
                christmas.model.RestaurantWaiter restaurantWaiter = new RestaurantWaiter(input);
                beforeDiscountCost = restaurantWaiter.getTotalMenuCost();
                return restaurantWaiter.getOrderedMenu();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}