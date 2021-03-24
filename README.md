# Discount Calculator

### Functionality
Calculates all the individual discounts than may be applied to the order with a priority

### Design
The main class of the calculator is DiscountService. It fetches customer discounts from a (fake) customer adapter and then delegates the calculation for the discounts to the appropriate discount calculators.
We are using the strategy pattern here. Each of the discount calculators is a strategy and is uniquely identified using DiscountType. DiscountService is constructing a map based on the existing implementations of the DiscountCalculator interface, so that it doesn't require any change when more discount calculators are added

### Execution
Execute mvn clean install and/or
Run DiscountServiceTest unit test. This will produce a list of these discounts:
[amount=17.00,percentage=5.00],name=PriceList Disc, [amount=32.30,percentage=10.00],name=Promotion X, [amount=10.00,percentage=<null>],name=Coupon 10EUROS



