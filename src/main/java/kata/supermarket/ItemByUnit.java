package kata.supermarket;

import java.math.BigDecimal;

public class ItemByUnit implements Item {

    private final UnitedProduct product;

    ItemByUnit(final UnitedProduct product) {
        this.product = product;
    }

    public BigDecimal price() {
        return product.pricePerUnit();
    }

    @Override
    public ProductIdentifier productIdentifier() {
        return product.productIdentifier();
    }
}
