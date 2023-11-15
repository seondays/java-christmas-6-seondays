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
        // 할인전 총주문 금액 출력
        OutputView.printBeforeDiscountCost(beforeDiscountCost);
        // 총 주문 금액에 따라서 샴페인 증정하기
        startGiftEvent();
        // 평일 혹은 주말 할인 하기
        startDiscount(DecemberDiscounter.of(date, beforeDiscountCost, orderedMenu));
        // 크리스마스 특별 할인 하기
        startDiscount(ChristmasDiscounter.of(date, afterDiscountCost));
        // 특별할인
        startDiscount(SpecialDiscounter.of(date, afterDiscountCost));
        printBenefitResult();
        inputView.close();
    }

    // 주문받기 시작
    public void orderProcess() {
        OutputView.printInputDateMessage();
        date = new Date(getInputDate());
        OutputView.printInputMenuMessage();
        orderedMenu = getMenu();
        OutputView.printDayInformation(date.getDay());
        OutputView.printMenu(orderedMenu);
    }

    // 마지막에 결과 출력해주기
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

    // 증정 이벤트를 체크해서 진행
    public void startGiftEvent() {
        Gift gift = new Gift(beforeDiscountCost);
        OutputView.printGift(gift.toString());
        benefitResultMaker.addGiftString(gift.getGiftPrice());
        discountAmount += gift.getGiftPrice();
    }

    // 날짜 입력 받기 구현
    public int getInputDate() {
        while (isInputIncomplete) {
            try {
                return Parser.parseStringToInt(inputView.getInputDate());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 메뉴 입력 받아서 리턴하기
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