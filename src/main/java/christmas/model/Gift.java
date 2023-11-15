package christmas.model;

import christmas.utils.constant.Menu;

public class Gift {
    private static final int GIFT_CONDITION = 120_000;
    private static final String GIFT_COUNT = " 1개";
    private final int cost;
    private Menu gift;

    public Gift(int cost) {
        this.cost = cost;
        checkCondition();
    }

    public Menu getGift() {
        return gift;
    }

    public int getGiftPrice() {
        return gift.getPrice();
    }

    private void checkCondition() {
        if (cost >= GIFT_CONDITION) {
            gift = Menu.CHAMPAGNE;
            return;
        }
        gift = Menu.NONE;
    }

    @Override
    public String toString() {
        String output = gift.getKoreaName();
        if (cost >= GIFT_CONDITION) {
            output += GIFT_COUNT;
        }
        return output;
    }
}
