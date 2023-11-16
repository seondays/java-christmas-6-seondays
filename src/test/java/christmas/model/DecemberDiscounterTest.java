package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.utils.constant.Menu;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DecemberDiscounterTest {
    private DecemberDiscounter decemberDiscounter;
    private DecemberDiscounter restaurantManager;
    private static Map<Menu, Integer> orderedMenu;

    @BeforeEach
    void init() {
        orderedMenu = Map.of(Menu.TBONE_STEAK, 4,
                Menu.CHOCOLATE_CAKE, 1, Menu.CHRISTMAS_PASTA, 1, Menu.ICE_CREAM, 1);
    }

    @ParameterizedTest
    @DisplayName("주어진 날짜에 따라 주문한 메뉴 중 몇가지 메뉴를 할인할지 알아낸다")
    @CsvSource(value = {"3:2", "15:5"}, delimiter = ':')
    void checkWeekOrWeekend(int days, int week) {
        Date date = new Date(days);
        restaurantManager = DecemberDiscounter.of(date, 10000, orderedMenu);
        assertThat(restaurantManager.countDiscountMenu()).isEqualTo(week);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:270000:265954","15:270000:259885"}, delimiter = ':')
    @DisplayName("주어진 날짜에 따라 올바르게 할인되는지 테스트")
    void discountCostRight(int days, int cost, int expected) {
        Date date = new Date(days);
        decemberDiscounter = DecemberDiscounter.of(date, cost, orderedMenu);
        assertThat(decemberDiscounter.discountCost()).isEqualTo(expected);
    }


    @ParameterizedTest
    @CsvSource(value = {"2:100000:10115", "26:100000:4046"}, delimiter = ':')
    @DisplayName("얼마를 할인받았는지를 반환하는지 테스트")
    void getDiscountAmount(int days, int menuCount, int expected) {
        Date date = new Date(days);
        decemberDiscounter = DecemberDiscounter.of(date, menuCount, orderedMenu);
        assertThat(decemberDiscounter.getResultAmount()).isEqualTo(expected);
    }
}