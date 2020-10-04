package kata.supermarket.basket;

import java.math.BigDecimal;
import java.util.List;

import kata.supermarket.Item;
import kata.supermarket.basket.discounts.DiscountService;

public class BasketTotalCalculator {

    private final TotalCalculator totalCalculator;
    private final DiscountService discountService;

    public BasketTotalCalculator(TotalCalculator totalCalculator, DiscountService discountService) {
        this.totalCalculator = totalCalculator;
        this.discountService = discountService;
    }

    private BigDecimal discounts(List<Item> items) {
        return discountService.calculateDiscount(totalCalculator, items);
    }

    public BigDecimal calculate(List<Item> items) {
        return totalCalculator.subtotalWithRound(items).subtract(discounts(items));
    }
}
