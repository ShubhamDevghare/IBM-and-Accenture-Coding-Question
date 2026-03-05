/*
There is a shop with old-style cash registers. Rather than scanning items and pulling the price from a database,
the price of each item is typed in manually. This method sometimes leads to errors.
Given a list of items and their correct prices, compare the prices to those entered when each item was sold.
Determine the number of errors in selling prices.

Example
products = ['eggs', 'milk', 'cheese']
productPrices = [2.89, 3.29, 5.79]

productSold = ['eggs', 'eggs', 'cheese', 'milk']
soldPrice = [2.89, 2.99, 5.97, 3.29]

| Product | Price Actual | Expected | Error |
| ------- | ------------ | -------- | ----- |
| eggs    | 2.89         | 2.89     |       |
| eggs    | 2.99         | 2.89     | 1     |
| cheese  | 5.97         | 5.79     | 1     |
| milk    | 3.29         | 3.29     |       |
The second sale of eggs has a wrong price, as does the sale of cheese. There are 2 errors in pricing.
Function Description
-------------------
Complete the function priceCheck in the editor below.
priceCheck has the following parameters:
string products[n]: the list of products
float productPrices[n]: the prices of the products
string productSold[m]: the products sold
float soldPrice[m]: the prices entered for the items sold

Returns
-------
int: the number of pricing errors

 */
/*
Example

Products:
     eggs   -> 2.89
     milk   -> 3.29
     cheese -> 5.79
Sold:
     eggs   2.89  ✓
     eggs   2.99  ✗
     cheese 5.97  ✗
     milk   3.29  ✓

 Errors = 2
 */
import java.util.*;

public class PriceCheck {

        public static int priceCheckFunction(List<String> products,
                                             List<Float> productPrices,
                                             List<String> productSold,
                                             List<Float> soldPrice) {

            Map<String, Float> priceMap = new HashMap<>();

            // Store product -> correct price
            for (int i = 0; i < products.size(); i++) {
                priceMap.put(products.get(i), productPrices.get(i));
            }

            int errors = 0;

            // Compare sold prices
            for (int i = 0; i < productSold.size(); i++) {
                float expectedPrice = priceMap.get(productSold.get(i));
                if (expectedPrice != soldPrice.get(i)) {
                    errors++;
                }
            }

            return errors;
        }
    }