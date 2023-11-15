package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ChristmasDiscounterTest {
    @ParameterizedTest
    @CsvSource(value = {"5:1400", "1:1000", "25:3400", "30:0"}, delimiter = ':')
    @DisplayName("날짜에 맞춰서 할인 금액이 올바르게 계산되는지 테스트")
    void discountByDay(int day, int expected) {
        Date date = new Date(day);
        ChristmasDiscounter christmasDiscounter = ChristmasDiscounter.of(date, 20_000);
        assertThat(christmasDiscounter.getResultAmount()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"7:18400", "20:17100", "26:20000"}, delimiter = ':')
    @DisplayName("할인 후 금액을 잘 반환해주는지 테스트")
    void discountCost(int day, int expected) {
        Date date = new Date(day);
        ChristmasDiscounter christmasDiscounter = ChristmasDiscounter.of(date, 20_000);
        assertThat(christmasDiscounter.discountCost()).isEqualTo(expected);
    }
}