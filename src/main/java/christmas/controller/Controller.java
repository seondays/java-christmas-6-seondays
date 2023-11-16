package christmas.controller;

import christmas.model.Date;
import christmas.utils.constant.Badge;
import christmas.model.ChristmasDiscounter;
import christmas.model.Discounter;
import christmas.model.Gift;
import christmas.utils.constant.Menu;
import christmas.model.DecemberDiscounter;
import christmas.model.RestaurantWaiter;
import christmas.model.BenefitResultMaker;
import christmas.model.SpecialDiscounter;
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
    private int afterDiscountCost;
    private int discountAmount;
    private Date date;

    public Controller(BenefitResultMaker benefitResultMaker, InputView inputView) {
        this.benefitResultMaker = benefitResultMaker;
        this.inputView = inputView;
    }

    public void run() {
        orderProcess();
        OutputView.printBeforeDiscountCost(beforeDiscountCost);
        startGiftEvent();
        startDiscount(DecemberDiscounter.of(date, beforeDiscountCost, orderedMenu));
        startDiscount(ChristmasDiscounter.of(date, afterDiscountCost));
        startDiscount(SpecialDiscounter.of(date, afterDiscountCost));
        printBenefitResult();
        inputView.close();
    }

    public void orderProcess() {
        OutputView.printInputDateMessage();
        date = new Date(getInputDate());
        OutputView.printInputMenuMessage();
        orderedMenu = getMenu();
        OutputView.printDayInformation(date.getDay());
        OutputView.printMenu(orderedMenu);
    }

    public void printBenefitResult() {
        OutputView.printBenefitInformation(benefitResultMaker.getBenefitResult());
        OutputView.printBenefitCost(discountAmount);
        OutputView.printPaymentCost(afterDiscountCost);
        OutputView.printBadgeInformation(Badge.getBadge(discountAmount));
    }

    public void startDiscount(Discounter discounter) {
        afterDiscountCost = discounter.discountCost();
        benefitResultMaker.addString(discounter.getResultAmount(), discounter.getDiscountMessage());
        discountAmount += discounter.getResultAmount();
    }

    public void startGiftEvent() {
        Gift gift = new Gift(beforeDiscountCost);
        OutputView.printGift(gift.toString());
        benefitResultMaker.addGiftString(gift.getGiftPrice());
        discountAmount += gift.getGiftPrice();
    }

    public int getInputDate() {
        while (isInputIncomplete) {
            try {
                return Parser.parseStringToInt(inputView.getInputDate());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Map<Menu, Integer> getMenu() {
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