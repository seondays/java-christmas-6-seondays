package christmas.view;

import christmas.utils.constant.Badge;
import christmas.utils.constant.Menu;
import christmas.utils.string.Formatter;
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

    public static void printBenefitInformation(StringBuilder sb) {
        System.out.printf(ViewInformationMessage.BENEFIT_LIST.getMessage());
        System.out.println(sb);
    }

    public static void printGift(String gift) {
        System.out.printf(ViewInformationMessage.GIFT_MENU.getMessage());
        System.out.println(gift);
    }

    public static void printBenefitCost(int discountAmount) {
        System.out.printf(ViewInformationMessage.BENEFIT_AMOUNT.getMessage());
        System.out.printf(ViewInformationMessage.MONEY_UNIT.getMessage(),
                Formatter.costFormat(discountAmount * MINUS_MARK));
    }

    public static void printPaymentCost(int afterDiscountCost) {
        System.out.printf(ViewInformationMessage.AFTER_COST.getMessage());
        System.out.printf(ViewInformationMessage.MONEY_UNIT.getMessage(), Formatter.costFormat(afterDiscountCost));
    }

    public static void printBadgeInformation(Badge badge) {
        System.out.printf(ViewInformationMessage.BADGE.getMessage());
        System.out.println(badge.getKoreaName());
    }
}
