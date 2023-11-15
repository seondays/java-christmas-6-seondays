package christmas.model;

import christmas.utils.constant.DiscountMessage;
import christmas.utils.constant.DiscounterConstant;
import christmas.utils.constant.Menu;
import java.time.LocalDate;
import java.util.EnumMap;
import java.util.Map;

public class DecemberDiscounter implements Discounter {
    private static final int DISCOUNT_AMOUNT = 2023;
    private Date date;
    private Map<Menu, Integer> orderedMenu;
    private final int resultAmount;
    private final int cost;

    public DecemberDiscounter(Date date, int cost, Map<Menu, Integer> orderedMenu) {
        this.date = date;
        this.cost = cost;
        this.orderedMenu = orderedMenu;
        resultAmount = countDiscountMenu() * DISCOUNT_AMOUNT;
    }

    @Override
    public int discountCost() {
        return cost - resultAmount;
    }

    @Override
    public int getResultAmount() {
        return resultAmount;
    }

    @Override
    public String getDiscountMessage() {
        if (isDayWeekend()) {
            return DiscountMessage.WEEKEND.getMessage();
        }
        return DiscountMessage.WEEK.getMessage();
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
        int dateNumber = date.getNumericDate();
        return dateNumber == DiscounterConstant.SATURDAY_MARK.getNumber()
                || dateNumber == DiscounterConstant.FRIDAY_MARK.getNumber();
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
