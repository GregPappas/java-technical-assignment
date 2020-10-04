package kata.supermarket.basket.discounts;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import kata.supermarket.Item;
import kata.supermarket.basket.TotalCalculator;

public class BuyOneGetOneFreeDiscountRule {
    // check whether it's possible to buy a quantity greater than max int
    private static final int MINIMUM_NUMBER_TO_APPLY_DISCOUNT = 2;
    private static final BigDecimal DIVIDE_BY = new BigDecimal("2");
    private static DiscountType discountType = DiscountType.BUY_ONE_GET_ONE_FREE_SINGLE_ITEM;

    public BigDecimal calculate(TotalCalculator totalCalculator, List<Item> items) {
        return  items.stream()
                .filter(item -> discountType.shouldApplyDiscount(item.productIdentifier()))
                .collect(Collectors.groupingBy(item -> item.productIdentifier()))
                .entrySet()
                .stream()
                .filter(i -> i.getValue().size() >= MINIMUM_NUMBER_TO_APPLY_DISCOUNT)
                .map(entrySet -> applyDiscount(totalCalculator, entrySet.getValue()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal applyDiscount(TotalCalculator totalCalculator, List<Item> items) {
        // if the items are even then we can just halve everything
        List<Item> itemsToApplyDiscount = items.size() % 2 == 0 ? items : items.subList(0, items.size() -1);
        return totalCalculator.subTotalNoRound(itemsToApplyDiscount).divide(DIVIDE_BY);
    }
}
