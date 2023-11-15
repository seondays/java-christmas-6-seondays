package christmas.utils.constant;

public enum DiscounterConstant {
    YEAR(2023),
    MONTH(12),
    SUNDAY_MARK(7),
    FRIDAY_MARK(5),
    SATURDAY_MARK(6),
    CHRISTMAS(25),
    DISCOUNT_DEFAULT_AMOUNT(1_000),
    MINIMUM_DISCOUNT_COST(10_000);

    private final int number;

    DiscounterConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
