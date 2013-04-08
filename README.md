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

==============
Following detail the cards I followed in order to work through this kata

1. init of item should set original price to passed in value
2. init should set original price duration = 0
3. init of item should set sale price = 0.0
4. init should set sale duration = 0
5. isPromo should return true when sale price is less than original price
6. isPromo should return false when sale price = 0.0
7. should set proper values when 'end promotion'
8. should reduce original price (original price duration not considered)
9. different percentage (original price duration not considered)
10. should not reduce original price when original price has not been stable for 30 days
11. should reduce original price only when original price duration greater than 30 days
12. price reduction should not occur if reduced less than 5 percent
13. price reduction should not occur if reduced more than 30 percent
14. promotion will last no longer than 30 days
15. if sale price is furhter reduced, the promotion will not be prolonged
16. if sale price reduced so overall reduction greater than 30 percent... promotion ends
17. if sales price increased, promotion ends immediately
18. if sales price increase is less than current sales price... do not end promotion
19. should be able to handle restart promo by resetting original price duration to zero on end promo


