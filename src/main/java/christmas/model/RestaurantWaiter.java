package christmas.model;

import christmas.utils.string.Parser;
import christmas.utils.constant.ErrorMessage;
import christmas.utils.constant.Menu;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class RestaurantWaiter {
    private final static int MIN_MENU_COUNT = 1;
    private final static int MAX_MENU_COUNT = 20;

    private final Map<Menu, Integer> orderedMenu = new EnumMap<>(Menu.class);

    public RestaurantWaiter(List<String> inputMenu) {
        saveMenu(inputMenu);
        validateMenuCount();
        validateDrinkOnly();
    }

    public void saveMenu(List<String> input) {
        for (String menu : input) {
            String[] afterSplit = Parser.splitMenu(menu);
            validateNone(afterSplit[0]);
            orderedMenu.put(Menu.validateOf(afterSplit[0])
                    , orderedMenu.getOrDefault(Menu.validateOf(afterSplit[0]), 0)
                            + Integer.parseInt(afterSplit[1]));
        }
    }

    private void validateMenuCount() {
        int menuCount = orderedMenu.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
        if (menuCount > MAX_MENU_COUNT || menuCount < MIN_MENU_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU.getMessage());
        }
    }

    private void validateDrinkOnly() {
        if (orderedMenu.keySet()
                .stream()
                .allMatch(menu -> menu.getMenuType().equals("drink"))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU.getMessage());
        }
    }

    private void validateNone(String menu) {
        if (menu.equals(Menu.NONE.getKoreaName())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU.getMessage());
        }
    }

    public Map<Menu, Integer> getOrderedMenu() {
        return orderedMenu;
    }

    public int getTotalMenuCost() {
        return orderedMenu.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue()).sum();
    }
}
