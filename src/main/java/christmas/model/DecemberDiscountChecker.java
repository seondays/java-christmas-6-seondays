package christmas.model;

import java.time.LocalDate;
import java.util.EnumMap;
import java.util.Map;

public class DecemberDiscountChecker {
    private int day;
    private Map<Menu, Integer> orderedMenu;

    public DecemberDiscountChecker(int day, Map<Menu, Integer> orderedMenu) {
        this.day = day;
        this.orderedMenu = orderedMenu;
    }

    // 해당되는 할인이 평일인지 주말인지 외부에 알려줘야 해
    public String getWeekOrWeekend() {
        if (isDayWeekend()) {
            return "주말 할인: ";
        }
        return "평일 할인: ";
    }

    // 날짜에 따라 메뉴에서 몇개를 할인해야 할지 알려줘
    public int countDiscountMenu() {
        if (isDayWeekend()) {
            return countMainMenu();
        }
        return countDessertMenu();
    }

    // 날짜가 평일인지 주말인지 알려줘
    private boolean isDayWeekend() {
        LocalDate date = LocalDate.of(2023, 12, day);
        int dateNumber = date.getDayOfWeek().getValue();
        return dateNumber == 6 || dateNumber == 5;
    }

    // 메뉴에서 디저트가 몇갠지 알려줘
    private int countDessertMenu() {
        return orderedMenu.entrySet().stream()
                .filter(entry -> entry.getKey().getMenuType().equals("dessert"))
                .mapToInt(EnumMap.Entry::getValue)
                .sum();
    }

    // 메뉴에서 메인이 몇갠지 알려줘
    private int countMainMenu() {
        return orderedMenu.entrySet().stream()
                .filter(entry -> entry.getKey().getMenuType().equals("main"))
                .mapToInt(Map.Entry::getValue)
                .sum();
    }
}
