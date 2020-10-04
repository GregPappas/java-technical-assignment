# Notes

Approach: 

Create a "DiscountService" that given a collection of items it can decide whether to apply a rule or not.

In order to do this with a minimal impact on the Basket object itself we'll start by extracting the Total Calculator from the Basket


Migrate the BigDecimal.ZERO into the newly created DiscountService
this is where we'll be able to do our work, currently tests that are in place cover these cases so no tests added yet.

Create the first DiscountRule which will be buy one get one free
Give product an identifier, for now we'll use an enum, however in a bigger system
this would probably be something tied to a database identifier.

Split the TotalCalculator and the BasketTotalCalculator to reuse parts of the calculator that are useful in multiple places


 