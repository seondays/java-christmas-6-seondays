package christmas.utils.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.utils.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    @ParameterizedTest
    @DisplayName("날짜 입력이 빈 값이면 예외가 발생한다")
    @ValueSource(strings = {"", " "})
    void inputDayIsBlank(String input) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateInputDate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_DAY.getMessage());
    }

    @ParameterizedTest
    @DisplayName("입력이 메뉴이름-수량이 아니면 예외가 발생한다")
    @ValueSource(strings = {"아이스크림--", "초코케이크"})
    void inputFormat(String input) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateInputMenu(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_MENU.getMessage());
    }

    @ParameterizedTest
    @DisplayName("입력이 숫자가 아니면 예외가 발생한다")
    @ValueSource(strings = {"아이스크림", "?!?"})
    void inputInt(String input) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateInputDate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_DAY.getMessage());
    }

}