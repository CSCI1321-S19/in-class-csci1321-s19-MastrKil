package basics

class MutableVect2D(private var _x: Double, private var _y: Double) {
  def x = _x
  def y = _y
  def x_=(newX: Double): Unit = _x = newX
  def y_=(newY: Double): Unit = _y = newY
  def +=(mv: MutableVect2D): MutableVect2D = {
    _x += mv.x
    _y += mv.y
    this
  }
  def -=(mv: MutableVect2D): MutableVect2D = {
    _x -= mv.x
    _y -= mv.y
    this
  }
  def *=(c: Double): MutableVect2D = {
    _x *= c
    _y *= c
    this
  }
  def /=(c: Double): MutableVect2D = {
    _x /= c
    _y /= c
    this
  }
  def magnitude = math.sqrt(x * x + y * y)
    
}

object MutableVect2D{
  def main(args: Array[String]): Unit = {
    val v1 = new MutableVect2D(1,2)
    val v2 = new MutableVect2D(1,2)
    v1 += (v2)
    println(v1.magnitude)
  }
}