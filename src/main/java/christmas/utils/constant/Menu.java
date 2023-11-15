package christmas.utils.constant;

import java.util.Arrays;

public enum Menu {
    MUSHROOM_SOUP("양송이수프", "appetizer", 6_000),
    TAPAS("타파스", "appetizer", 5_500),
    CAESAR_SALAD("시저샐러드", "appetizer", 8_000),
    TBONE_STEAK("티본스테이크", "main", 55_000),
    BARBECUE_LIP("바비큐립", "main", 54_000),
    SEAFOOD_PASTA("해산물파스타", "main", 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", "main", 25_000),
    CHOCOLATE_CAKE("초코케이크", "dessert", 15_000),
    ICE_CREAM("아이스크림", "dessert", 5_000),
    ZERO_COKE("제로콜라", "drink", 3_000),
    RED_WINE("레드와인", "drink", 60_000),
    CHAMPAGNE("샴페인", "drink", 25_000),
    NONE("없음","none",0);

    private final String koreaName;
    private final String menuType;
    private final int price;

    Menu(String koreaName, String menuType, int price) {
        this.koreaName = koreaName;
        this.menuType = menuType;
        this.price = price;
    }

    public static Menu validateOf(String koreaName) {
        return Arrays.stream(values())
                .filter(menu -> menu.koreaName.equals(koreaName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_MENU.getMessage()));
    }

    public String getMenuType() {
        return menuType;
    }

    public int getPrice() {
        return price;
    }

    public String getKoreaName() {
        return koreaName;
    }
}
