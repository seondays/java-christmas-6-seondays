package christmas.view;

import christmas.model.Menu;
import java.util.Map;

public class OutputView {
    public static void printMenu(Map<Menu, Integer> menuMap) {
        System.out.println("<주문 메뉴>");
        menuMap.forEach((k, v) -> System.out.println(k.getKoreaName() + " " + v + "개"));
    }
}
