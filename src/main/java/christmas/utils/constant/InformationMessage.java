package christmas.utils.constant;

public enum InformationMessage {
    GREETING("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    DAY_INPUT_GUIDE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    MENU_INPUT_GUIDE("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    BENEFIT_PREVIEW("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!%n"),
    ORDER_MENU("%n<주문 메뉴>%n"),
    BEFORE_COST("%n<할인 전 총주문 금액>%n"),
    BENEFIT_LIST("%n<혜택 내역>%n"),
    GIFT_MENU("%n<증정 메뉴>%n"),
    BENEFIT_AMOUNT("<총혜택 금액>%n"),
    AFTER_COST("%n<할인 후 예상 결제 금액>%n"),
    BADGE("%n<12월 이벤트 배지>%n"),
    MONEY_UNIT("%s원%n"),
    COUNT_UNIT("%s %d개%n");

    private String message;

    InformationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
