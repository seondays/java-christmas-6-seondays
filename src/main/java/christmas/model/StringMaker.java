package christmas.model;

import christmas.utils.string.Formatter;
import christmas.utils.constant.DiscountMessage;
import christmas.utils.constant.Menu;

public class StringMaker {
    // 스트링빌더를 관리할거야. 출력을 위해서.
    private static final int MINUS_MARK = -1;
    private static final int MIN_CONDITION = 0;
    private final StringBuilder sb = new StringBuilder();

    // 증정품 관련해서 추가해줘
    public void addGiftString(int discountAmount) {
        if (discountAmount == Menu.CHAMPAGNE.getPrice()) {
            sb.append(DiscountMessage.GIFT_EVENT.getMessage());
            sb.append(Formatter.costFormat(discountAmount * MINUS_MARK));
            sb.append(DiscountMessage.MONEY_UNIT.getMessage());
        }
    }

    //버퍼가 비어있다 -> 없음을 추가해야 함
    public StringBuilder getSb() {
        if (sb.isEmpty()) {
            sb.append(DiscountMessage.NONE.getMessage());
        }
        return sb;
    }

    // 크리스마스 디데이 할인 관련 추가해줘
    public void addString(int discountAmount, String message) {
        if (discountAmount > MIN_CONDITION) {
            sb.append(message);
            sb.append(Formatter.costFormat(discountAmount * MINUS_MARK));
            sb.append(DiscountMessage.MONEY_UNIT.getMessage());
        }
    }
}
