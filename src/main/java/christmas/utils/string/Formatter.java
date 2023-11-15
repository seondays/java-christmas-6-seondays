package christmas.utils.string;

import java.text.DecimalFormat;

public class Formatter {
    public static String costFormat(int cost) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(cost);
    }
}
