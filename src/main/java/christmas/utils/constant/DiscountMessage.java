package christmas.utils.constant;

public enum DiscountMessage {
    GIFT_EVENT("증정 이벤트: "),
    MONEY_UNIT("원\n"),
    NONE("없음\n"),
    CHRISTMAS("\"크리스마스 디데이 할인: \""),
    SPECIAL("특별 할인: "),
    WEEK("평일 할인: "),
    WEEKEND("주말 할인: ");

    private final String message;

    DiscountMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
