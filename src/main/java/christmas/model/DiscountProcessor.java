package christmas.model;

import christmas.utils.constant.Menu;
import java.util.Map;

public class DiscountProcessor {
    private final Map<Menu, Integer> orderedMenu;
    private final Date date;
    private final BenefitResultMaker benefitResultMaker;
    private int discountCost;
    private int discountAmount;

    public DiscountProcessor(int discountCost, Date date, Map<Menu, Integer> orderedMenu,
                             BenefitResultMaker benefitResultMaker) {
        this.discountCost = discountCost;
        this.date = date;
        this.orderedMenu = orderedMenu;
        this.benefitResultMaker = benefitResultMaker;
    }

    public void start() {
        decemberDiscount();
        christmasDiscount();
        specialDiscount();
    }

    public void decemberDiscount() {
        Discounter discounter = DecemberDiscounter.of(date, discountCost, orderedMenu);
        startDiscount(discounter);
    }

    public void christmasDiscount() {
        Discounter discounter = ChristmasDiscounter.of(date, discountCost);
        startDiscount(discounter);
    }

    public void specialDiscount() {
        Discounter discounter = SpecialDiscounter.of(date, discountCost);
        startDiscount(discounter);
    }

    private void startDiscount(Discounter discounter) {
        discountCost = discounter.discountCost();
        benefitResultMaker.addString(discounter.getResultAmount(), discounter.getDiscountMessage());
        discountAmount += discounter.getResultAmount();
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public int getDiscountCost() {
        return discountCost;
    }
}