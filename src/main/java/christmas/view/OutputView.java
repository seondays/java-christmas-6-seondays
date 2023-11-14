package christmas.view;

import christmas.model.Badge;
import christmas.model.Gift;
import christmas.model.Menu;
import christmas.utils.Formatter;
import java.util.Map;

public class OutputView {
    public static void printInputDateMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

    public static void printInputMenuMessage() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    public static void printDayInformation(int day) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!%n", day);
    }

    public static void printMenu(Map<Menu, Integer> menuMap) {
        System.out.printf("%n<주문 메뉴>%n");
        menuMap.forEach((k, v) -> System.out.println(k.getKoreaName() + " " + v + "개"));
    }

    public static void printBeforeDiscountCost(int beforeDiscountCost) {
        System.out.printf("%n<할인 전 총주문 금액>%n");
        System.out.println(Formatter.costFormat(beforeDiscountCost) + "원");
    }

    // 혜택 내역 출력하기
    public static void printBenefitInformation(StringBuilder sb) {
        System.out.printf("%n<혜택 내역>%n");
        System.out.println(sb);
    }

    // 증정 내역 출력하기
    public static void printGift(Gift gift) {
        System.out.printf("%n<증정 메뉴>%n");
        System.out.println(gift);
    }

    // 총 혜택 금액 출력하기
    public static void printBenefitCost(int discountAmount) {
        System.out.printf("<총혜택 금액>%n");
        System.out.println(discountAmount * -1 + "원");
    }

    // 예상 결제 금액 출력하기
    public static void printPaymentCost(int afterDiscountCost) {
        System.out.printf("%n<할인 후 예상 결제 금액>%n");
        System.out.println(afterDiscountCost + "원");
    }

    // 이벤트 뱃지 정보 출력하기
    public static void printBadgeInformation(Badge badge) {
        System.out.printf("%n<12월 이벤트 배지>%n");
        System.out.println(badge.getKoreaName());
    }
}
