package christmas.model;

public class Gift {
    private static final int GIFT_CONDITION = 120_000;
    private final int cost;
    private Menu gift;

    public Gift(int cost) {
        this.cost = cost;
        checkCondition();
    }

    public Menu getGift() {
        return gift;
    }

    public int getGiftAmount() {
        return gift.getPrice();
    }

    private void checkCondition() {
        if (cost >= GIFT_CONDITION) {
            gift = Menu.CHAMPAGNE;
            return;
        }
        gift = Menu.NONE;
    }
}
