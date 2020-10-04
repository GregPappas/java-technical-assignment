package kata.supermarket.basket;

import kata.supermarket.Item;
import kata.supermarket.basket.discounts.DiscountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static kata.supermarket.ItemTestBuilders.aPackOfDigestives;
import static kata.supermarket.ItemTestBuilders.aPintOfMilk;
import static kata.supermarket.ItemTestBuilders.twoFiftyGramsOfAmericanSweets;
import static kata.supermarket.ItemTestBuilders.twoHundredGramsOfPickAndMix;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketTest {

    private DiscountService discountService = new DiscountService();
    private TotalCalculator totalCalculator = new TotalCalculator();
    private BasketTotalCalculator basketTotalCalculator = new BasketTotalCalculator(
            totalCalculator,
            discountService);

    @DisplayName("basket provides its total value when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void basketProvidesTotalValue(String description, String expectedTotal, Iterable<Item> items) {
        final Basket basket = new Basket(basketTotalCalculator);
        items.forEach(basket::add);
        assertEquals(new BigDecimal(expectedTotal), basket.total());
    }

    static Stream<Arguments> basketProvidesTotalValue() {
        return Stream.of(
                noItems(),
                aSingleItemPricedPerUnit(),
                multipleItemsPricedPerUnit(),
                aSingleItemPricedByWeight(),
                multipleItemsPricedByWeight(),
                twoPintsOfMilk()
        );
    }

    private static Arguments aSingleItemPricedByWeight() {
        return Arguments.of("a single weighed item", "1.25", Collections.singleton(twoFiftyGramsOfAmericanSweets()));
    }

    private static Arguments multipleItemsPricedByWeight() {
        return Arguments.of("multiple weighed items", "1.85",
                Arrays.asList(twoFiftyGramsOfAmericanSweets(), twoHundredGramsOfPickAndMix())
        );
    }

    private static Arguments multipleItemsPricedPerUnit() {
        return Arguments.of("multiple items priced per unit", "2.04",
                Arrays.asList(aPackOfDigestives(), aPintOfMilk()));
    }

    private static Arguments twoPintsOfMilk() {
        return Arguments.of("two pints of a milk with a buy one get one free", "0.49",
                Arrays.asList(aPintOfMilk(), aPintOfMilk()));
    }

    private static Arguments aSingleItemPricedPerUnit() {
        return Arguments.of("a single item priced per unit", "0.49", Collections.singleton(aPintOfMilk()));
    }

    private static Arguments noItems() {
        return Arguments.of("no items", "0.00", Collections.emptyList());
    }
}