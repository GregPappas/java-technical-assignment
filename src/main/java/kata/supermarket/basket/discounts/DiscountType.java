package kata.supermarket.basket.discounts;

import static kata.supermarket.ProductIdentifier.MILK;
import static kata.supermarket.ProductIdentifier.ORANGE_JUICE;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import kata.supermarket.ProductIdentifier;

public enum DiscountType {
    BUY_ONE_GET_ONE_FREE_SINGLE_ITEM(new HashSet<>(Arrays.asList(MILK, ORANGE_JUICE)));

    private final Set<ProductIdentifier> itemsForDiscount;

    DiscountType(Set<ProductIdentifier> itemsForDiscount) {
        this.itemsForDiscount = itemsForDiscount;
    }

    boolean shouldApplyDiscount(ProductIdentifier identifier) {
        return itemsForDiscount.contains(identifier);
    }
}
