package christmas.model;

public class DiscountProcessor {

    //할인하기 전 금액
    private final int beforeDiscountCost;
    //할인을 마친 이후 금액
    private int afterDiscountCost;
    //할인을 얼마나 받았는지의 금액
    private int discountAmount;

    public DiscountProcessor(int beforeDiscountCost) {
        this.beforeDiscountCost = beforeDiscountCost;
    }

    public int getAfterDiscountCost() {
        return afterDiscountCost;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public int getBeforeDiscountCost() {
        return beforeDiscountCost;
    }
}
