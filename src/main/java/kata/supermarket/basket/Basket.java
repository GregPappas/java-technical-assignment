package kata.supermarket.basket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import kata.supermarket.Item;

public class Basket {
    private final TotalCalculator totalCalculator;
    private final List<Item> items;

    public Basket(TotalCalculator totalCalculator) {
        this.totalCalculator = totalCalculator;
        this.items = new ArrayList<>();
    }

    public void add(final Item item) {
        this.items.add(item);
    }

    public BigDecimal total() {
        return totalCalculator.calculate(items);
    }
}
