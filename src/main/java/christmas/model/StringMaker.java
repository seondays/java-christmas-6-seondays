package christmas.model;

import christmas.utils.Formatter;

public class StringMaker {
    // 스트링버퍼를 관리할거야. 출력을 위해서.
    private StringBuilder sb = new StringBuilder();

    // 스트링버퍼에 원하는 걸 추가해줘
    public void addGiftString(int discountAmount) {
        if (discountAmount == Menu.CHAMPAGNE.getPrice()) {
            sb.append("증정 이벤트: ");
            sb.append(Formatter.costFormat(discountAmount * -1));
            sb.append("원\n");
        }
    }

    //버퍼가 비어있다 -> 없음을 추가해야 함
    public StringBuilder getSb() {
        if (sb.isEmpty()) {
            sb.append("없음");
        }
        return sb;
    }

    // 크리스마스 디데이 할인 관련 추가해줘
    public void addChristmasString(int discountAmount) {
        if (discountAmount > 0) {
            sb.append("크리스마스 디데이 할인: ");
            sb.append(Formatter.costFormat(discountAmount * -1));
            sb.append("원\n");
        }
    }

    // 평일 주말 할인 관련 추가해줘
    public void addWeekOrWeekendString(int discountAmount, String weekOfWeekend) {
        if (discountAmount > 0) {
            sb.append(weekOfWeekend);
            sb.append(Formatter.costFormat(discountAmount * -1));
            sb.append("원\n");
        }
    }

    //특별 할인 관련 추가해줘
    public void addSpecialString(int discountAmount) {
        if(discountAmount > 0) {
            sb.append("특별 할인: ");
            sb.append(Formatter.costFormat(discountAmount * -1));
            sb.append("원\n");
        }
    }

}
