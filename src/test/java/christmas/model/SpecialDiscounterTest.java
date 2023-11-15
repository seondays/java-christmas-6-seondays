package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SpecialDiscounterTest {

    @ParameterizedTest
    @DisplayName("특별 할인 조건에 맞게 할인 금액이 계산되는지")
    @CsvSource(value = {"3:1000", "26:0", "25:1000"}, delimiter = ':')
    void discountByCondition(int days, int expected) {
        Date date = new Date(days);
        SpecialDiscounter specialDiscounter = SpecialDiscounter.of(date, 30_000);
        assertThat(specialDiscounter.getResultAmount()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("특별 할인 금액만큼 할인이 잘 적용되는지")
    @CsvSource(value = {"28:30000","25:29000","13:30000"}, delimiter = ':')
    void discountCost(int days, int expected) {
        Date date = new Date(days);
        SpecialDiscounter specialDiscounter = SpecialDiscounter.of(date, 30_000);
        assertThat(specialDiscounter.discountCost()).isEqualTo(expected);
    }

}