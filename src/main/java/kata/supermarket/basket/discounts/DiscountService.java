package kata.supermarket.basket.discounts;

import java.math.BigDecimal;
import java.util.List;

import kata.supermarket.Item;
import kata.supermarket.basket.TotalCalculator;

public class DiscountService {

    private BuyOneGetOneFreeDiscountRule buyOneGetOneFree = new BuyOneGetOneFreeDiscountRule();

    public BigDecimal calculateDiscount(TotalCalculator totalCalculator, List<Item> items) {
        return  totalCalculator.round(buyOneGetOneFree.calculate(totalCalculator, items));
    }
}
