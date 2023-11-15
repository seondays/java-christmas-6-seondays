package christmas.model;

import christmas.utils.constant.DiscountMessage;
import christmas.utils.constant.DiscounterConstant;

public class SpecialDiscounter implements Discounter {
    private final Date date;
    private final int cost;
    private int resultAmount;

    public SpecialDiscounter(Date date, int cost) {
        this.date = date;
        this.cost = cost;
        setResultAmount();
    }

    @Override
    public int discountCost() {
        return cost - resultAmount;
    }

    @Override
    public int getResultAmount() {
        return resultAmount;
    }

    @Override
    public String getDiscountMessage() {
        return DiscountMessage.SPECIAL.getMessage();
    }

    private void setResultAmount() {
        if (isCanDiscount() && isOverMinimum()) {
            resultAmount = DiscounterConstant.DISCOUNT_DEFAULT_AMOUNT.getNumber();
            return;
        }
        resultAmount = 0;
    }

    private boolean isCanDiscount() {
        int dateNumber = date.getNumericDate();
        return dateNumber == DiscounterConstant.SUNDAY_MARK.getNumber()
                || date.getDay() == DiscounterConstant.CHRISTMAS.getNumber();
    }

    private boolean isOverMinimum() {
        return cost >= DiscounterConstant.MINIMUM_DISCOUNT_COST.getNumber();
    }
}
