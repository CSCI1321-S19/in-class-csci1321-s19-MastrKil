package basics

class Vect2D(val x: Double, val y: Double) {
  def +(v: Vect2D) = new Vect2D(x + v.x, y + v.y)
  def -(v: Vect2D) = new Vect2D(x - v.x, y - v.y)
  def *(c: Double) = new Vect2D(x * c, y * c)
  def /(c: Double) = new Vect2D(x / c, y / c)
  def unary_-() = new Vect2D(-x, -y)
  def magnitude = math.sqrt(x * x + y * y)
}

object Vect2D {
  def main(args: Array[String]): Unit = {
    val v1 = new Vect2D(1,2)
    val v2 = new Vect2D(1,2)
    val v3 = v1 + v2
    println(v3.magnitude)
  }
}