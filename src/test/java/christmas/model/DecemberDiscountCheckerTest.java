package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.utils.constant.Menu;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DecemberDiscountCheckerTest {

    private DecemberDiscountChecker restaurantManager;
    private static Map<Menu, Integer> orderedMenu;

    @BeforeEach
    void init() {
        orderedMenu = Map.of(Menu.TBONE_STEAK,4,
                Menu.CHOCOLATE_CAKE,1,Menu.CHRISTMAS_PASTA,1,Menu.ICE_CREAM,1);
    }

    @ParameterizedTest
    @DisplayName("주어진 날짜에 따라 주문한 메뉴 중 몇가지 메뉴를 할인할지 알아낸다")
    @CsvSource(value = {"3:2", "15:5"}, delimiter = ':')
    void checkWeekOrWeekend(int days, int week) {
        restaurantManager = new DecemberDiscountChecker(days, orderedMenu);
        assertThat(restaurantManager.countDiscountMenu()).isEqualTo(week);
    }
}