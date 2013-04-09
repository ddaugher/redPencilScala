import org.scalatest.{BeforeAndAfter, FunSuite}

class redPencilScalaSpec extends FunSuite with BeforeAndAfter {

  var i: redPencilScala = _

  before {
    i = new redPencilScala(100.0)
  }

  test("init of item should set original price to passed in value") {
    assert(100.0 === i.originalPrice)
  }

  test("init of item should set sale price = 0.0") {
    assert(0.0 === i.salePrice)
  }

  test("init should set sale duration = 0") {
    assert(0 === i.saleDuration)
  }

  test("isPromo should return true when sale price is less than original price") {
    i.salePrice = 95.0
    assert(true === i.isPromo())
  }

  test("isPromo should return false when sale price = 0.0") {
    i.salePrice = 0.0
    assert(false === i.isPromo())
  }

  test("should set proper values when 'end promotion'") {
    i.salePrice = 90.0
    i.saleDuration = 15
    i.endPromotion()

    assert(100.0 === i.originalPrice)
    assert(0.0 === i.salePrice)
    assert(0 === i.saleDuration)
  }

  test("should reduce original price") {
    i.originalPriceDuration = 30
    i.reducePriceByPercentage(10)
    assert(90.0 === i.salePrice)
  }

  test("should reduce original price by a different percentage") {
    i.originalPriceDuration = 30
    i.reducePriceByPercentage(20)
    assert(80.0 === i.salePrice)
  }

  test("init should set original price duration = 0") {
    assert(0 === i.originalPriceDuration)
  }

  test("should not reduce original price when original price has not been stable for 30 days") {
    i.originalPriceDuration = 29
    i.reducePriceByPercentage(10)
    assert(0.0 === i.salePrice)
    assert(false === i.isPromo())
  }

  test("should reduce original price only when original price duration greater than 30 days") {
    i.originalPriceDuration = 30
    i.reducePriceByPercentage(10)
    assert(90.0 === i.salePrice)
    assert(true === i.isPromo())
  }

  test("price reduction should not occur if reduced less than 5 percent") {
    i.originalPriceDuration = 30
    i.reducePriceByPercentage(4)
    assert(0.0 === i.salePrice)
    assert(false === i.isPromo())
  }

  test("price reduction should not occur if reduced more than 30 percent") {
    i.originalPriceDuration = 30
    i.reducePriceByPercentage(31)
    assert(0.0 === i.salePrice)
    assert(false === i.isPromo())
  }

  test("promotion will last no longer than 30 days") {
    i.originalPriceDuration = 30
    i.reducePriceByPercentage(10)

    i.saleDuration = 31

    assert(0.0 === i.salePrice)
    assert(0 === i.saleDuration)
    assert(false === i.isPromo())
  }

  test("if sale price is further reduced, the promotion will not be prolonged") {
    i.originalPriceDuration = 30
    i.reducePriceByPercentage(10)
    i.saleDuration = 15
    i.reducePriceByPercentage(10)
    assert(81.0 === i.salePrice)
    assert(15 === i.saleDuration)
    assert(true === i.isPromo())
  }

  test("if sale price reduced so overall reduction greater than 30 percent... promo ends") {
    i.originalPriceDuration = 30
    i.reducePriceByPercentage(10)
    i.reducePriceByPercentage(10)
    assert(true === i.isPromo())
    i.reducePriceByPercentage(15)
    assert(0.0 === i.salePrice)
    assert(0 === i.saleDuration)
    assert(false === i.isPromo())
  }

  test("if sale price increased, promotion end immediately") {
    i.originalPriceDuration = 30
    i.reducePriceByPercentage(10)
    i.increaseSalePrice(95.0)
    assert(0.0 === i.salePrice)
    assert(0 === i.saleDuration)
    assert(false === i.isPromo())
  }

  test("if sales price increase is less than current sales price... do not end promo") {
    i.originalPriceDuration = 30
    i.reducePriceByPercentage(10)
    i.saleDuration = 15

    assert(90.0 === i.salePrice)

    i.increaseSalePrice(89.0)

    assert(90.0 === i.salePrice)
    assert(15 === i.saleDuration)
    assert(true === i.isPromo())
  }
}
