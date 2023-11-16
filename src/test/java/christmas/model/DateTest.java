package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DateTest {
    @ParameterizedTest
    @CsvSource(value = {"1:5", "25:1", "16:6"}, delimiter = ':')
    @DisplayName("날짜에 맞는 숫자가 올바르게 반환된다")
    void numberByDay(int day, int expected) {
        Date date = new Date(day);
        assertThat(date.getNumericDate()).isEqualTo(expected);
    }

    @DisplayName("날짜에 1~31 이외의 값을 입력하면 예외가 발생한다")
    @Test
    void createDateByOverSize() {
        assertThatThrownBy(() -> new Date(32))
                .isInstanceOf(IllegalArgumentException.class);
    }
}