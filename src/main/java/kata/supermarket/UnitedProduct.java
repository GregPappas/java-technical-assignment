package kata.supermarket;

import java.math.BigDecimal;

public class UnitedProduct implements Product {

    private final BigDecimal pricePerUnit;
    private final ProductIdentifier productIdentifier;

    public UnitedProduct(final ProductIdentifier skuIdentifier, final BigDecimal pricePerUnit) {
        this.productIdentifier = skuIdentifier;
        this.pricePerUnit = pricePerUnit;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(this);
    }

    @Override
    public ProductIdentifier productIdentifier() {
        return productIdentifier;
    }
}
