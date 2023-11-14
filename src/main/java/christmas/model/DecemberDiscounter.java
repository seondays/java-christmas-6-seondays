package christmas.model;

public class DecemberDiscounter implements Discounter{
    private static final int DISCOUNT_AMOUNT = 2023;
    private final int resultAmount;
    private final int cost;

    public DecemberDiscounter(int cost, int menuCount) {
        resultAmount = menuCount * DISCOUNT_AMOUNT;
        this.cost = cost;
    }

    @Override
    public int discountCost() {
        return cost - resultAmount;
    }

    @Override
    public int getResultAmount() {
        return resultAmount;
    }
}
