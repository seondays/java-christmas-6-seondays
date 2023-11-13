package christmas.model;

public class DecemberDiscounter {
    private static final int DISCOUNT_AMOUNT = 2023;
    private final int resultAmount;
    private final int cost;

    public DecemberDiscounter(int cost, int menuCount) {
        resultAmount = menuCount * DISCOUNT_AMOUNT;
        this.cost = cost;
    }

    public int discountCost() {
        return cost - resultAmount;
    }

    public int getResultAmount() {
        return resultAmount;
    }
}
