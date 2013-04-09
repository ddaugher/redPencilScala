class redPencilScala(private val _originalPrice:Double = 0.0) {

  private var _originalPriceDuration: Int = 0
  private var _salePrice: Double = 0.0

  def originalPrice:Double = _originalPrice
  def originalPriceDuration:Int = _originalPriceDuration
  def salePrice:Double = _salePrice
}
