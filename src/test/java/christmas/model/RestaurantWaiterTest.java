package christmas.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import christmas.utils.constant.ErrorMessage;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RestaurantWaiterTest {

    @Test
    @DisplayName("메뉴의 총 수량이 20개를 넘어가면 예외처리한다")
    void checkOverSize() {
        List<String> orderedMenu = List.of("티본스테이크-1","바비큐립-18","초코케이크-2","제로콜라-1");
        assertThatThrownBy(() -> new RestaurantWaiter(orderedMenu))
                .isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.INVALID_MENU.getMessage());
    }

    @Test
    @DisplayName("메뉴의 총 수량이 20개를 넘어가면 예외처리한다")
    void checkDrinkOnly() {
        List<String> orderedMenu = List.of("제로콜라-1");
        assertThatThrownBy(() -> new RestaurantWaiter(orderedMenu))
                .isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.INVALID_MENU.getMessage());
    }

    @Test
    @DisplayName("없음이 입력되었을 경우 예외처리한다.")
    void checkNone() {
        List<String> orderedMenu = List.of("없음-1");
        assertThatThrownBy(() -> new RestaurantWaiter(orderedMenu))
                .isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.INVALID_MENU.getMessage());
    }
}