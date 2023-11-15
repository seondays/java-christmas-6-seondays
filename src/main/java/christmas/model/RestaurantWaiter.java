package christmas.model;

import christmas.utils.Parser;
import christmas.utils.constant.ErrorMessage;
import christmas.utils.constant.Menu;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class RestaurantWaiter {
    private final static int MIN_MENU_COUNT = 1;
    private final static int MAX_MENU_COUNT = 20;

    // 메뉴를 입력받아 다루는 클래스
    private Map<Menu, Integer> orderedMenu = new EnumMap<>(Menu.class);

    public RestaurantWaiter(List<String> inputMenu) {
        saveMenu(inputMenu);
        validateMenuCount();
        validateDrinkOnly();
    }

    //입력받은 메뉴를 Map에 저장
    public void saveMenu(List<String> input) {
        for (String menu : input) {
            String[] afterSplit = Parser.splitMenu(menu);
            validateNone(afterSplit[0]);
            orderedMenu.put(Menu.valuesOf(afterSplit[0])
                    , orderedMenu.getOrDefault(Menu.valuesOf(afterSplit[0]), 0)
                            + Integer.parseInt(afterSplit[1]));
        }
    }

    // 메뉴의 총 수량을 체크한다.
    private void validateMenuCount() {
        int menuCount = orderedMenu.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
        if (menuCount > MAX_MENU_COUNT || menuCount < MIN_MENU_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU.getMessage());
        }
    }

    // 음료만 주문하는 경우 예외처리 해야 한다
    private void validateDrinkOnly() {
        if (orderedMenu.keySet()
                .stream()
                .allMatch(menu -> menu.getMenuType().equals("drink"))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU.getMessage());
        }
    }

    // 없음이 입력되었을때 예외처리 해야 한다.
    private void validateNone(String menu) {
        if (menu.equals(Menu.NONE.getKoreaName())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU.getMessage());
        }
    }

    public Map<Menu, Integer> getOrderedMenu() {
        return orderedMenu;
    }

    // 메뉴의 총 가격을 계산해준다
    public int getTotalMenuCost() {
        return orderedMenu.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue()).sum();
    }
}
