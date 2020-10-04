package kata.supermarket;

import java.math.BigDecimal;

public class ItemTestBuilders {
    public static Item aPintOfMilk() {
        return new Product(new BigDecimal("0.49")).oneOf();
    }

    public static Item aPackOfDigestives() {
        return new Product(new BigDecimal("1.55")).oneOf();
    }

    public static WeighedProduct aKiloOfAmericanSweets() {
        return new WeighedProduct(new BigDecimal("4.99"));
    }

    public static Item twoFiftyGramsOfAmericanSweets() {
        return aKiloOfAmericanSweets().weighing(new BigDecimal(".25"));
    }

    public static WeighedProduct aKiloOfPickAndMix() {
        return new WeighedProduct(new BigDecimal("2.99"));
    }

    public static Item twoHundredGramsOfPickAndMix() {
        return aKiloOfPickAndMix().weighing(new BigDecimal(".2"));
    }
}
