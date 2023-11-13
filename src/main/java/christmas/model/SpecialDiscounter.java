package christmas.model;

import java.time.LocalDate;

public class SpecialDiscounter {
    private final int day;
    private final int cost;
    private int resultAmount;

    public SpecialDiscounter(int day, int cost) {
        this.day = day;
        this.cost = cost;
        setResultAmount();
    }

    public int discountCost() {
        return cost - resultAmount;
    }

    public int getResultAmount() {
        return resultAmount;
    }

    private void setResultAmount() {
        if (isCanDiscount()) {
            resultAmount = 1000;
            return;
        }
        resultAmount = 0;
    }

    private boolean isCanDiscount() {
        LocalDate date = LocalDate.of(2023, 12, day);
        int dateNumber = date.getDayOfWeek().getValue();
        return dateNumber == 7 || day == 25;
    }
}
