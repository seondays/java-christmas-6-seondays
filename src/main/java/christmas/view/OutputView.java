package christmas.view;

import christmas.model.Badge;
import christmas.model.Gift;
import christmas.model.Menu;
import christmas.utils.Formatter;
import java.util.Map;

public class OutputView {
    public static void printMenu(Map<Menu, Integer> menuMap) {
        System.out.println("<주문 메뉴>");
        menuMap.forEach((k, v) -> System.out.println(k.getKoreaName() + " " + v + "개"));
    }

    // 혜택 내역 출력하기
    public static void printBenefitInformation(StringBuilder sb) {
        System.out.println("<혜택 내역>");
        System.out.println(sb);
    }
}
