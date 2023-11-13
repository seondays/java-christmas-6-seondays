package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DecemberDiscounterTest {
    private DecemberDiscounter decemberDiscounter;

    @ParameterizedTest
    @CsvSource(value = {"10000:3:3931", "20000:6:7862"}, delimiter = ':')
    @DisplayName("총 금액과 할인할 메뉴의 개수를 전달하면 메뉴당 2023만큼 할인해 주는지 테스트")
    void discountCostRight(int cost, int menuCount, int expected) {
        decemberDiscounter = new DecemberDiscounter(cost, menuCount);
        assertThat(decemberDiscounter.discountCost()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"10000:3:6069", "20000:6:12138"}, delimiter = ':')
    @DisplayName("얼마를 할인받았는지를 잘 반환하는지 테스트")
    void getDiscountAmount(int cost, int menuCount, int expected) {
        decemberDiscounter = new DecemberDiscounter(cost, menuCount);
        assertThat(decemberDiscounter.getResultAmount()).isEqualTo(expected);
    }
}