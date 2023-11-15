package christmas.view;

import christmas.utils.constant.Badge;
import christmas.utils.constant.Menu;
import christmas.utils.Formatter;
import christmas.utils.constant.ViewInformationMessage;
import java.util.Map;

public class OutputView {
    private static final int MINUS_MARK = -1;

    public static void printInputDateMessage() {
        System.out.println(ViewInformationMessage.GREETING.getMessage());
        System.out.println(ViewInformationMessage.DAY_INPUT_GUIDE.getMessage());
    }

    public static void printInputMenuMessage() {
        System.out.println(ViewInformationMessage.MENU_INPUT_GUIDE.getMessage());
    }

    public static void printDayInformation(int day) {
        System.out.printf(ViewInformationMessage.BENEFIT_PREVIEW.getMessage(), day);
    }

    public static void printMenu(Map<Menu, Integer> menuMap) {
        System.out.printf(ViewInformationMessage.ORDER_MENU.getMessage());
        menuMap.forEach((k, v) -> System.out.printf(ViewInformationMessage.COUNT_UNIT.getMessage(), k.getKoreaName(), v));
    }

    public static void printBeforeDiscountCost(int beforeDiscountCost) {
        System.out.printf(ViewInformationMessage.BEFORE_COST.getMessage());
        System.out.printf(ViewInformationMessage.MONEY_UNIT.getMessage(), Formatter.costFormat(beforeDiscountCost));
    }

    // 혜택 내역 출력하기
    public static void printBenefitInformation(StringBuilder sb) {
        System.out.printf(ViewInformationMessage.BENEFIT_LIST.getMessage());
        System.out.println(sb);
    }

    // 증정 내역 출력하기
    public static void printGift(String gift) {
        System.out.printf(ViewInformationMessage.GIFT_MENU.getMessage());
        System.out.println(gift);
    }

    // 총 혜택 금액 출력하기
    public static void printBenefitCost(int discountAmount) {
        System.out.printf(ViewInformationMessage.BENEFIT_AMOUNT.getMessage());
        System.out.printf(ViewInformationMessage.MONEY_UNIT.getMessage(),
                Formatter.costFormat(discountAmount * MINUS_MARK));
    }

    // 예상 결제 금액 출력하기
    public static void printPaymentCost(int afterDiscountCost) {
        System.out.printf(ViewInformationMessage.AFTER_COST.getMessage());
        System.out.printf(ViewInformationMessage.MONEY_UNIT.getMessage(), Formatter.costFormat(afterDiscountCost));
    }

    // 이벤트 뱃지 정보 출력하기
    public static void printBadgeInformation(Badge badge) {
        System.out.printf(ViewInformationMessage.BADGE.getMessage());
        System.out.println(badge.getKoreaName());
    }
}
