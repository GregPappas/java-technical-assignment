package kata.supermarket.basket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import kata.supermarket.Item;
import kata.supermarket.basket.discounts.DiscountService;

class TotalCalculator {
    private final DiscountService discountService;

    public TotalCalculator(DiscountService discountService) {
        this.discountService = discountService;
    }

    protected BigDecimal subtotal(List<Item> items) {
        return items.stream().map(Item::price)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal discounts(List<Item> items) {
        return discountService.calculateDiscount(items);
    }

    public BigDecimal calculate(List<Item> items) {
        return subtotal(items).subtract(discounts(items));
    }
}
