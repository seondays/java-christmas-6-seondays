package christmas.model;

import christmas.utils.constant.DiscountMessage;
import christmas.utils.constant.DiscounterConstant;
import christmas.utils.constant.Menu;
import java.time.LocalDate;
import java.util.EnumMap;
import java.util.Map;

public class DecemberDiscounter implements Discounter {
    private static final int DISCOUNT_AMOUNT = 2023;
    private final int resultAmount;
    private final int cost;
    private final Date date;
    private final Map<Menu, Integer> orderedMenu;

    private DecemberDiscounter(Date date, int cost, Map<Menu, Integer> orderedMenu) {
        this.date = date;
        this.cost = cost;
        this.orderedMenu = orderedMenu;
        resultAmount = countDiscountMenu() * DISCOUNT_AMOUNT;
    }

    public static DecemberDiscounter of(Date date, int cost, Map<Menu, Integer> orderedMenu) {
        return new DecemberDiscounter(date, cost, orderedMenu);
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

    public int countDiscountMenu() {
        if (isDayWeekend()) {
            return countMainMenu();
        }
        return countDessertMenu();
    }

    private boolean isDayWeekend() {
        int dateNumber = date.getNumericDate();
        return dateNumber == DiscounterConstant.SATURDAY_MARK.getNumber()
                || dateNumber == DiscounterConstant.FRIDAY_MARK.getNumber();
    }

    private int countDessertMenu() {
        return orderedMenu.entrySet().stream()
                .filter(entry -> entry.getKey().getMenuType().equals("dessert"))
                .mapToInt(EnumMap.Entry::getValue)
                .sum();
    }

    private int countMainMenu() {
        return orderedMenu.entrySet().stream()
                .filter(entry -> entry.getKey().getMenuType().equals("main"))
                .mapToInt(Map.Entry::getValue)
                .sum();
    }
}
