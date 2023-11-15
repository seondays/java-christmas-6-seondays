package christmas.model;

import christmas.utils.constant.DiscounterConstant;
import java.time.LocalDate;

public class SpecialDiscounter implements Discounter {
    private final int day;
    private final int cost;
    private int resultAmount;

    public SpecialDiscounter(int day, int cost) {
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

    private void setResultAmount() {
        if (isCanDiscount() && isOverMinimum()) {
            resultAmount = DiscounterConstant.DISCOUNT_DEFAULT_AMOUNT.getNumber();
            return;
        }
        resultAmount = 0;
    }

    private boolean isCanDiscount() {
        LocalDate date = LocalDate.of(DiscounterConstant.YEAR.getNumber(),
                DiscounterConstant.MONTH.getNumber(), day);
        int dateNumber = date.getDayOfWeek().getValue();
        return dateNumber == DiscounterConstant.SUNDAY_MARK.getNumber()
                || day == DiscounterConstant.CHRISTMAS.getNumber();
    }

    private boolean isOverMinimum() {
        return cost >= DiscounterConstant.MINIMUM_DISCOUNT_COST.getNumber();
    }
}
