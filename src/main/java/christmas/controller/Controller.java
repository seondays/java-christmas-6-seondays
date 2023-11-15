package christmas.controller;

import christmas.utils.constant.Badge;
import christmas.model.ChristmasDiscounter;
import christmas.model.DecemberDiscounter;
import christmas.model.Discounter;
import christmas.model.Gift;
import christmas.utils.constant.Menu;
import christmas.model.DecemberDiscountChecker;
import christmas.model.RestaurantWaiter;
import christmas.model.StringMaker;
import christmas.model.SpecialDiscounter;
import christmas.utils.Parser;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;
import java.util.Map;

public class Controller {
    private Map<Menu, Integer> orderedMenu;
    private Discounter discounter;
    private DecemberDiscountChecker decemberDiscountChecker;
    private int beforeDiscountCost;
    private int afterDiscountCost;
    private int discountAmount;
    StringMaker stringMaker = new StringMaker();
    InputView inputView = new InputView();
    private int day;
    RestaurantWaiter RestaurantWaiter;

    public void run() {
        orderProcess();
        decemberDiscountChecker = new DecemberDiscountChecker(day, orderedMenu);
        // 할인전 총주문 금액 출력
        OutputView.printBeforeDiscountCost(beforeDiscountCost);
        // 총 주문 금액에 따라서 샴페인 증정하기
        startGiftEvent();
        // 평일 혹은 주말 할인 하기
        startDecemberDiscount();
        // 크리스마스 특별 할인 하기
        startChristmasDiscount();
        // 특별할인
        startSpecialDiscount();
        printResult();
    }

    public void orderProcess() {
        OutputView.printInputDateMessage();
        day = getInputDate();
        OutputView.printInputMenuMessage();
        orderedMenu = getMenu();
        OutputView.printDayInformation(day);
        OutputView.printMenu(orderedMenu);
    }

    // 마지막에 결과 출력해주기
    public void printResult() {
        OutputView.printBenefitInformation(stringMaker.getSb());
        OutputView.printBenefitCost(discountAmount);
        OutputView.printPaymentCost(afterDiscountCost);
        OutputView.printBadgeInformation(Badge.getBadge(discountAmount));
    }

    // 특별 할인을 체크해서 진행
    public void startSpecialDiscount() {
        discounter = new SpecialDiscounter(day, afterDiscountCost);
        afterDiscountCost = discounter.discountCost();
        stringMaker.addSpecialString(discounter.getResultAmount());
        discountAmount += discounter.getResultAmount();
    }

    // 크리스마스 할인을 체크해서 진행
    public void startChristmasDiscount() {
        discounter = new ChristmasDiscounter(day, afterDiscountCost);
        afterDiscountCost = discounter.discountCost();
        stringMaker.addChristmasString(discounter.getResultAmount());
        discountAmount += discounter.getResultAmount();
    }

    // 증정 이벤트를 체크해서 진행
    public void startGiftEvent() {
        Gift gift = new Gift(beforeDiscountCost);
        OutputView.printGift(gift.toString());
        stringMaker.addGiftString(gift.getGiftAmount());
        discountAmount += gift.getGiftAmount();
    }

    // 12월 할인을 체크해서 진행
    public void startDecemberDiscount() {
        discounter = new DecemberDiscounter(beforeDiscountCost, decemberDiscountChecker.countDiscountMenu());
        afterDiscountCost = discounter.discountCost();
        stringMaker.addWeekOrWeekendString(discounter.getResultAmount(),
                decemberDiscountChecker.getWeekOrWeekend());
        discountAmount += discounter.getResultAmount();
    }

    // 날짜 입력 받기 구현
    public int getInputDate() {
        while (true) {
            try {
                return Integer.parseInt(inputView.getInputDate());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 메뉴 입력 받아서 리턴하기
    public Map<Menu, Integer> getMenu() {
        while (true) {
            try {
                List<String> input = Parser.splitInput(inputView.getInputMenu());
                RestaurantWaiter = new RestaurantWaiter(input);
                beforeDiscountCost = RestaurantWaiter.getTotalMenuCost();
                return RestaurantWaiter.getOrderedMenu();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
