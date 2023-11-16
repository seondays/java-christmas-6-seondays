package christmas.model;

import christmas.utils.constant.DiscounterConstant;
import christmas.utils.constant.ErrorMessage;
import java.time.LocalDate;

public class Date {
    private final static int MIN_DAY = 1;
    private final static int MAX_DAY = 31;
    private final int day;

    public Date(int day) {
        validateRange(day);
        this.day = day;
    }

    public int getNumericDate() {
        LocalDate date = LocalDate.of(DiscounterConstant.YEAR.getNumber(), DiscounterConstant.MONTH.getNumber(), day);
        return date.getDayOfWeek().getValue();
    }

    public int getDay() {
        return day;
    }

    private void validateRange(int input) {
        if (input < MIN_DAY || input > MAX_DAY) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DAY.getMessage());
        }
    }
}
