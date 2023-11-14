package christmas.utils;

public class InputValidator {

    // 날짜 검증 메서드 만들기
    public void validateInputDate(String input) {
        validateInputBlank(input);
        validateInputInt(input);
        validateRange(input);
    }

    // 메뉴 검증 메서드 만들기

    // 메뉴이름-수량 의 형식인지
    // 메뉴판에 존재하는 메뉴인지
    // 최소 1개 이상 20개 이하의 주문인지
    // 빈 값인지
    // 음료만 단독으로 주문할 수 없음

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
