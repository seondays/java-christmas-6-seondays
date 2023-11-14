package christmas.model;

public enum Badge {
    STAR(5_000,"별"),
    TREE(10_000,"트리"),
    SANTA(20_000,"산타"),
    NONE(0,"없음");

    private int condition;
    private String koreaName;

    Badge(int condition, String koreaName) {
        this.condition = condition;
        this.koreaName = koreaName;
    }

    public String getKoreaName() {
        return koreaName;
    }

    public static Badge getBadge(int cost) {
        if (cost < STAR.condition) {
            return NONE;
        }
        if (cost < TREE.condition) {
            return STAR;
        }
        if (cost < SANTA.condition) {
            return TREE;
        }
        return SANTA;
    }
}
