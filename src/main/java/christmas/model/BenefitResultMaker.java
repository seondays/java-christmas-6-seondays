package christmas.model;

import christmas.utils.string.Formatter;
import christmas.utils.constant.DiscountMessage;
import christmas.utils.constant.Menu;

public class BenefitResultMaker {
    private static final int MINUS_MARK = -1;
    private static final int MIN_CONDITION = 0;
    private final StringBuilder benefitResult = new StringBuilder();

    public void addGiftString(int discountAmount) {
        if (discountAmount == Menu.CHAMPAGNE.getPrice()) {
            benefitResult.append(DiscountMessage.GIFT_EVENT.getMessage());
            benefitResult.append(Formatter.costFormat(discountAmount * MINUS_MARK));
            benefitResult.append(DiscountMessage.MONEY_UNIT.getMessage());
        }
    }

    public StringBuilder getBenefitResult() {
        if (benefitResult.isEmpty()) {
            benefitResult.append(DiscountMessage.NONE.getMessage());
        }
        return benefitResult;
    }

    public void addString(int discountAmount, String message) {
        if (discountAmount > MIN_CONDITION) {
            benefitResult.append(message);
            benefitResult.append(Formatter.costFormat(discountAmount * MINUS_MARK));
            benefitResult.append(DiscountMessage.MONEY_UNIT.getMessage());
        }
    }
}
