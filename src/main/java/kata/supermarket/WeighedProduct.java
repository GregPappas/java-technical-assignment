package kata.supermarket;

import java.math.BigDecimal;

public class WeighedProduct implements Product {

    private final BigDecimal pricePerKilo;
    private final ProductIdentifier productIdentifier;

    public WeighedProduct(final ProductIdentifier productIdentifier, final BigDecimal pricePerKilo) {
        this.pricePerKilo = pricePerKilo;
        this.productIdentifier = productIdentifier;
    }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }

    @Override
    public ProductIdentifier productIdentifier() {
        return productIdentifier;
    }
}
