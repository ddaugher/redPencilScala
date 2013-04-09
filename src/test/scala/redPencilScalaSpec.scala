import org.scalatest.{BeforeAndAfter, FunSuite}

class redPencilScalaSpec extends FunSuite with BeforeAndAfter {

  var i: redPencilScala = _

  before {
    i = new redPencilScala(100.0)
  }

  test("init of item should set original price to passed in value") {
    assert(100.0 === i.originalPrice)
  }
}
