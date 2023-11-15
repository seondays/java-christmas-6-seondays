package christmas.model;

import christmas.utils.Formatter;
import christmas.utils.constant.DiscountMessage;
import christmas.utils.constant.Menu;

public class StringMaker {
    // 스트링빌더를 관리할거야. 출력을 위해서.
    private static final int MINUS_MARK = -1;
    private static final int MIN_CONDITION = 0;
    private StringBuilder sb = new StringBuilder();

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
    public void addChristmasString(int discountAmount) {
        if (discountAmount > MIN_CONDITION) {
            sb.append(DiscountMessage.CHRISTMAS.getMessage());
            sb.append(Formatter.costFormat(discountAmount * MINUS_MARK));
            sb.append(DiscountMessage.MONEY_UNIT.getMessage());
        }
    }

    // 평일 주말 할인 관련 추가해줘
    public void addWeekOrWeekendString(int discountAmount, String weekOfWeekend) {
        if (discountAmount > MIN_CONDITION) {
            sb.append(weekOfWeekend);
            sb.append(Formatter.costFormat(discountAmount * MINUS_MARK));
            sb.append(DiscountMessage.MONEY_UNIT.getMessage());
        }
    }

    //특별 할인 관련 추가해줘
    public void addSpecialString(int discountAmount) {
        if(discountAmount > MIN_CONDITION) {
            sb.append(DiscountMessage.SPECIAL.getMessage());
            sb.append(Formatter.costFormat(discountAmount * MINUS_MARK));
            sb.append(DiscountMessage.MONEY_UNIT.getMessage());
        }
    }
}
