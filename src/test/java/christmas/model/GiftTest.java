package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.utils.constant.Menu;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GiftTest {
    private static Stream<Arguments> giftConditionSource() {
        return Stream.of(
                Arguments.of(120000, Menu.CHAMPAGNE),
                Arguments.of(90000, Menu.NONE)
        );
    }
    @ParameterizedTest
    @DisplayName("총 주문 금액이 12만원 이상이면 샴페인을 증정하는지")
    @MethodSource("giftConditionSource")
    void checkGiftCondition(int cost, Menu menu) {
        Gift gift = new Gift(cost);
        assertThat(gift.getGift()).isEqualTo(menu);
    }

    @Test
    @DisplayName("증정품의 할인 가치가 얼마인지 알맞게 반환하는지")
    void getGiftResultAmount() {
        Gift gift = new Gift(120000);
        assertThat(gift.getGiftAmount()).isEqualTo(25000);
    }
}