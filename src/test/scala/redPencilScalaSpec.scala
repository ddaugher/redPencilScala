import org.scalatest.{BeforeAndAfter, FunSuite}

class redPencilScalaSpec extends FunSuite with BeforeAndAfter {

  var i: redPencilScala = _

  before {
    i = new redPencilScala(100.0)
  }

  test("init of item should set original price to passed in value") {
    assert(100.0 === i.originalPrice)
  }

  test("init should set original price duration = 0") {
    assert(0 === i.originalPriceDuration)
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
}
