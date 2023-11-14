package christmas.model;

import christmas.utils.constant.SpecialDiscounterConstant;
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
            resultAmount = SpecialDiscounterConstant.DISCOUNT_DEFAULT_AMOUNT.getNumber();
            return;
        }
        resultAmount = 0;
    }

    private boolean isCanDiscount() {
        LocalDate date = LocalDate.of(SpecialDiscounterConstant.YEAR.getNumber(),
                SpecialDiscounterConstant.MONTH.getNumber(), day);
        int dateNumber = date.getDayOfWeek().getValue();
        return dateNumber == SpecialDiscounterConstant.SUNDAY_MARK.getNumber()
                || day == SpecialDiscounterConstant.CHRISTMAS.getNumber();
    }

    private boolean isOverMinimum() {
        return cost >= SpecialDiscounterConstant.MINIMUM_DISCOUNT_COST.getNumber();
    }
}
