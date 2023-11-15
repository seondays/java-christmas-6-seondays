package christmas.view;

import christmas.model.Badge;
import christmas.model.Menu;
import christmas.utils.Formatter;
import christmas.utils.constant.InformationMessage;
import java.util.Map;

public class OutputView {
    private static final int MINUS_MARK = -1;

    public static void printInputDateMessage() {
        System.out.println(InformationMessage.GREETING.getMessage());
        System.out.println(InformationMessage.DAY_INPUT_GUIDE.getMessage());
    }

    public static void printInputMenuMessage() {
        System.out.println(InformationMessage.MENU_INPUT_GUIDE.getMessage());
    }

    public static void printDayInformation(int day) {
        System.out.printf(InformationMessage.BENEFIT_PREVIEW.getMessage(), day);
    }

    public static void printMenu(Map<Menu, Integer> menuMap) {
        System.out.printf(InformationMessage.ORDER_MENU.getMessage());
        menuMap.forEach((k, v) -> System.out.printf(InformationMessage.COUNT_UNIT.getMessage(), k.getKoreaName(), v));
    }

    public static void printBeforeDiscountCost(int beforeDiscountCost) {
        System.out.printf(InformationMessage.BEFORE_COST.getMessage());
        System.out.printf(InformationMessage.MONEY_UNIT.getMessage(), Formatter.costFormat(beforeDiscountCost));
    }

    // 혜택 내역 출력하기
    public static void printBenefitInformation(StringBuilder sb) {
        System.out.printf(InformationMessage.BENEFIT_LIST.getMessage());
        System.out.println(sb);
    }

    // 증정 내역 출력하기
    public static void printGift(String gift) {
        System.out.printf(InformationMessage.GIFT_MENU.getMessage());
        System.out.println(gift);
    }

    // 총 혜택 금액 출력하기
    public static void printBenefitCost(int discountAmount) {
        System.out.printf(InformationMessage.BENEFIT_AMOUNT.getMessage());
        System.out.printf(InformationMessage.MONEY_UNIT.getMessage(),
                Formatter.costFormat(discountAmount * MINUS_MARK));
    }

    // 예상 결제 금액 출력하기
    public static void printPaymentCost(int afterDiscountCost) {
        System.out.printf(InformationMessage.AFTER_COST.getMessage());
        System.out.printf(InformationMessage.MONEY_UNIT.getMessage(), Formatter.costFormat(afterDiscountCost));
    }

    // 이벤트 뱃지 정보 출력하기
    public static void printBadgeInformation(Badge badge) {
        System.out.printf(InformationMessage.BADGE.getMessage());
        System.out.println(badge.getKoreaName());
    }
}
