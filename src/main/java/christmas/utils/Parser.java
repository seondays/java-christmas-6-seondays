package christmas.utils;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private final static String INPUT_REGEX = ",";
    private final static String MENU_REGEX = "-";

    public static List<String> splitInput(String input) {
        return Arrays.stream(input.split(INPUT_REGEX))
                .map(String::trim)
                .toList();
    }

    public static String[] splitMenu(String menu) {
        return menu.split(MENU_REGEX);
    }

    public static int parseStringToInt(String input) {
        return Integer.parseInt(input);
    }
}
