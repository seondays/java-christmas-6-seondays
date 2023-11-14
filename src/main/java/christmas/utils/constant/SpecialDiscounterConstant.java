package christmas.utils.constant;

public enum SpecialDiscounterConstant {
    YEAR(2023),
    MONTH(12),
    SUNDAY_MARK(7),
    CHRISTMAS(25),
    DISCOUNT_DEFAULT_AMOUNT(1_000),
    MINIMUM_DISCOUNT_COST(10_000);

    private final int number;

    SpecialDiscounterConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
