package christmas.utils;

import java.util.List;

public class InputValidator {

    // 날짜 검증 메서드 만들기
    public void validateInputDate(String input) {
        validateInputBlank(input);
        validateInputInt(input);
        validateRange(input);
    }

    // 메뉴 검증 메서드 만들기
    public void validateInputMenu(String input) {
        List<String> inputSplit = Parser.splitInput(input);
        validateInputMenuBlank(input);
        validateInputFormat(inputSplit);
    }

    // 메뉴이름-수량 의 형식인지
    private void validateInputFormat(List<String> input) {
        for(String order : input) {
            if(!order.matches("[가-힣]+-\\d+")) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }
    // 빈 값인지
    private void validateInputMenuBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
    // 입력값이 빈 값인지
    private void validateInputBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
    // 입력값이 숫자인지
    private void validateInputInt(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
    // 입력값이 1~31 사이인지
    private void validateRange(String input) {
        int inputInt = Integer.parseInt(input);
        if (inputInt < 1 || inputInt > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}