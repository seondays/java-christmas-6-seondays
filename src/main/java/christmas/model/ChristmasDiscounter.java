package christmas.model;

import christmas.utils.constant.ChristmasDiscounterConstant;
import christmas.utils.constant.DiscountMessage;

public class ChristmasDiscounter implements Discounter {
    private final int day;
    private final int cost;
    private int resultAmount;

    public ChristmasDiscounter(int day, int cost) {
        this.day = day;
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

    public String getDiscountMessage() {
        return DiscountMessage.CHRISTMAS.getMessage();
    }

    private void setResultAmount() {
        if (day <= ChristmasDiscounterConstant.LIMIT_DAY.getNumber() && isOverMinimum()) {
            resultAmount =
                    ChristmasDiscounterConstant.DISCOUNT_DEFAULT_AMOUNT.getNumber()
                            + ((day - ChristmasDiscounterConstant.CHRISTMAS_DAY_CONTROL.getNumber())
                            * ChristmasDiscounterConstant.EVERY_DAY_ADD_AMOUNT.getNumber());
            return;
        }
        resultAmount = 0;
    }

    private boolean isOverMinimum() {
        return cost >= ChristmasDiscounterConstant.MINIMUM_DISCOUNT_COST.getNumber();
    }
}
