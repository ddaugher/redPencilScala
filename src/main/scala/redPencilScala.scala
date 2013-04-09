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
    if (days > 30) {
      endPromotion()
      return
    }
    _saleDuration = days
  }

  def originalPriceDuration_=(price: Int): Unit = {
    _originalPriceDuration = price
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

  def increaseSalePrice(price:Double):Unit = {
    if(price < _salePrice) {
      return
    }
    _salePrice = 0.0
    _saleDuration = 0
  }

  def reducePriceByPercentage(percentage:Int):Unit = {
    if (isInvalidPercentage(percentage)) return
    if (_originalPriceDuration < 30) return
    val newPrice: Double = getNewPrice(percentage)
    if ((_originalPrice - newPrice) / 100.0 > .30) {
      endPromotion()
      return
    }
    _salePrice = newPrice
  }

  private def getNewPrice(percentage: Int): Double = {
    val newPrice: Double = (100.0 - percentage) / 100.0 * getCurrentPrice
    newPrice
  }

  private def getCurrentPrice: Double = {
    (if (_salePrice != 0.0) _salePrice else _originalPrice)
  }

  private def isInvalidPercentage(percentage: Int): Boolean = {
    if (percentage < 5) return true
    if (percentage > 30) return true
    false
  }
}
