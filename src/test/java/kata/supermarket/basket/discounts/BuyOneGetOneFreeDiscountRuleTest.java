package kata.supermarket.basket.discounts;

import static kata.supermarket.ItemTestBuilders.aLitreOfOrangeJuice;
import static kata.supermarket.ItemTestBuilders.aPackOfDigestives;
import static kata.supermarket.ItemTestBuilders.aPintOfMilk;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import kata.supermarket.Item;
import kata.supermarket.basket.TotalCalculator;
import org.junit.jupiter.api.Test;

class BuyOneGetOneFreeDiscountRuleTest {

    private BuyOneGetOneFreeDiscountRule buyOneGetOneFreeDiscountRule = new BuyOneGetOneFreeDiscountRule();
    private TotalCalculator totalCalculator = new TotalCalculator();

    @Test
    public void whenASingleItemIsProvidedAndBuyOneGetOneFreeIsValidThenNoDiscountIsApplied() {
        //setup
        List<Item> items = Arrays.asList(aPintOfMilk());
        //act
        BigDecimal result = buyOneGetOneFreeDiscountRule.calculate(totalCalculator, items);
        //verify
        assertTrue(result.equals(BigDecimal.ZERO));
    }

    @Test
    public void whenTwoOfTheSameItemArePassedInAndBuyOneGetOneFreeIsValidThenApplyADiscount() {
        //setup
        Item milk = aPintOfMilk();
        List<Item> items = Arrays.asList(milk, milk);
        BigDecimal expectedResult = milk.price();
        //act
        BigDecimal result = buyOneGetOneFreeDiscountRule.calculate(totalCalculator, items);
        assertEquals(expectedResult, result);
    }

    @Test
    public void whenThreeOfTheSameItemArePassedInAndBuyOneGetOneFreeIsValidApplyTheCorrectDiscount() {
        Item milk = aPintOfMilk();

        List<Item> items = Arrays.asList(milk, milk, milk);
        BigDecimal expectedResult = milk.price();
        //act
        BigDecimal result = buyOneGetOneFreeDiscountRule.calculate(totalCalculator, items);
        assertEquals(expectedResult, result);
    }

    @Test
    public void whenANonDiscountedItemIsPassedInThenNoDiscountIsApplied() {
        Item milk = aPintOfMilk();
        Item digestives = aPackOfDigestives();
        List<Item> items = Arrays.asList(milk, milk, digestives, digestives);
        BigDecimal expectedResult = milk.price();
        //act
        BigDecimal result = buyOneGetOneFreeDiscountRule.calculate(totalCalculator, items);
        assertEquals(expectedResult, result);
    }

    @Test
    public void whenMultipleDiscountsAreAppliedThenTheNumberIsAdded() {
        Item milk = aPintOfMilk();
        Item orangeJuice = aLitreOfOrangeJuice();
        List<Item> items = Arrays.asList(milk, milk, orangeJuice, orangeJuice);
        BigDecimal expectedResult = milk.price().add(orangeJuice.price());
        //act
        BigDecimal result = buyOneGetOneFreeDiscountRule.calculate(totalCalculator, items);
        assertEquals(expectedResult, result);

    }
}