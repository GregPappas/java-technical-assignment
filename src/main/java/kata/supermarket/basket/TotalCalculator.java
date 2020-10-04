package kata.supermarket.basket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import kata.supermarket.Item;

public class TotalCalculator {

    public BigDecimal subtotalWithRound(List<Item> items) {
        return round(subTotalNoRound(items));
    }

    public BigDecimal round(BigDecimal value) {
        return value.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal subTotalNoRound(List<Item> items) {
        return items.stream().map(Item::price)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

}
