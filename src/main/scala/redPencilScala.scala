class redPencilScala(private val _originalPrice:Double = 0.0) {

  private var _originalPriceDuration: Int = 0
  private var _salePrice: Double = 0.0
  private var _saleDuration: Int = 0

  def originalPrice:Double = _originalPrice
  def originalPriceDuration:Int = _originalPriceDuration
  def salePrice:Double = _salePrice
  def saleDuration:Int = _saleDuration

  def salePrice_=(price: Double): Unit = {
    _salePrice = price
  }

  def saleDuration_=(days: Int): Unit = {
    _saleDuration = days
  }

  def isPromo():Boolean = {
    if (_salePrice == 0.0) return false
    if (_salePrice < _originalPrice) return true
    false
  }

  def endPromotion():Unit = {
    _salePrice = 0.0
    _saleDuration = 0
  }

  def reducePriceByPercentage(percentage:Int):Unit = {
    val newPrice:Double = (100.0 - percentage) / 100.0 * _originalPrice
    _salePrice = newPrice
  }

}
