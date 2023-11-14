package christmas.model;

public class ChristmasDiscounter {
    private static final int LIMIT_DAY = 25;
    private static final int DEFAULT_AMOUNT = 1000;
    private static final int EVERY_DAY_ADD_AMOUNT = 100;
    private static final int DAY_CONTROL = 1;
    private final int day;
    private final int cost;
    private int resultAmount;

    public ChristmasDiscounter(int day, int cost) {
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
        if (day <= LIMIT_DAY && isOverMinimum()) {
            resultAmount = DEFAULT_AMOUNT + ((day - DAY_CONTROL) * EVERY_DAY_ADD_AMOUNT);
            return;
        }
        resultAmount = 0;
    }

    private boolean isOverMinimum() {
        return cost >= 10000;
    }
}
