package christmas.utils.constant;

public enum ChristmasDiscounterConstant {
    LIMIT_DAY(25),
    CHRISTMAS_DAY_CONTROL(1),
    DISCOUNT_DEFAULT_AMOUNT(1000),
    EVERY_DAY_ADD_AMOUNT(100),
    MINIMUM_DISCOUNT_COST(10_000);

    private final int number;

    ChristmasDiscounterConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
