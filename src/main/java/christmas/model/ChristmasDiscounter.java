package christmas.model;

import christmas.utils.constant.ChristmasDiscounterConstant;
import christmas.utils.constant.DiscountMessage;

public class ChristmasDiscounter implements Discounter {
    private final Date date;
    private final int cost;
    private int resultAmount;

    private ChristmasDiscounter(Date date, int cost) {
        this.date = date;
        this.cost = cost;
        setResultAmount();
    }

    public static ChristmasDiscounter of(Date date, int cost) {
        return new ChristmasDiscounter(date, cost);
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
        return DiscountMessage.CHRISTMAS.getMessage();
    }

    private void setResultAmount() {
        if (date.getDay() <= ChristmasDiscounterConstant.LIMIT_DAY.getNumber() && isOverMinimum()) {
            resultAmount = ChristmasDiscounterConstant.DISCOUNT_DEFAULT_AMOUNT.getNumber()
                    + ((date.getDay() - ChristmasDiscounterConstant.CHRISTMAS_DAY_CONTROL.getNumber())
                    * ChristmasDiscounterConstant.EVERY_DAY_ADD_AMOUNT.getNumber());
            return;
        }
        resultAmount = 0;
    }

    private boolean isOverMinimum() {
        return cost >= ChristmasDiscounterConstant.MINIMUM_DISCOUNT_COST.getNumber();
    }
}
