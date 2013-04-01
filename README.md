redPencilScala
==============

Red Pencil Code Kata

We provide a shopping portal, where dealers can offer their goods (similiar to Amazon market place). 
We want to support red pencil promotions for reduced prices. During the red pencil promotion the old 
price is crossed out in red and the new reduced price is written next to it.

To avoid misuse of red pencil promotions the red pencil promotions are activated and deactivated automatically.

The scope of the this kata is the implementation of the rules for activation and end of red pencil promotions.

A red pencil promotion starts by 
  - reducing the original price
  - the reduction has to be reduced by at least 5%
  - the reducution cannot be at most 30% and
  - the original price has to be stable for at least 30 days.

The maximim length of a red pencil promotion is 30 days.

The sale price can be further reduced in price during a red pencil promotion.

If the sale price is further reduced during the red pencil promotion the promotion will not be prolonged by that reduction.

If the sale price is increased during the red pencil promotion the promotion will be ended immediately.

If the sales price if reduced during the red pencil promotion so that the overall reduction is more than 
30% with regard to the original price, the promotion is ended immediately.

After a red pencil promotion has ended, additional red pencil promotions may follow – 
as long as the start condition is valid: 
  - the price was stable for 30 days and 
  - these 30 days don’t intersect with a previous red pencil promotion.
