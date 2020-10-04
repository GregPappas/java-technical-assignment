package kata.supermarket.basket.discounts;

import static kata.supermarket.ItemTestBuilders.aPintOfMilk;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import kata.supermarket.Item;
import org.junit.jupiter.api.Test;

class DiscountServiceTest {

    @Test
    public void whenASingleItemIsProvidedAndBuyOneGetOneFreeIsValidThenNoDiscountIsApplied() {
        //setup
        DiscountService discountService = new DiscountService();
        List<Item> items = new ArrayList<>();
        items.add(aPintOfMilk());
        //act
        BigDecimal result = discountService.calculateDiscount(items);
        //verify
        assertTrue(result.equals(BigDecimal.ZERO));
    }

}