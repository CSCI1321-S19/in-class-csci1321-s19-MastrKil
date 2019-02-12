package puyo

class Twoyo(val p1: Puyo, val p2: Puyo) {
  def move(dx: Int, dy: Int): Twoyo = {
    if (isClear(dx, dy)) {
      new Twoyo(p1.move(dx, dy), p2.move(dx, dy))
    } else this
  }

  def isClear(dx: Int, dy: Int): Boolean = {
    p1.isClear(dx, dy) && p2.isClear(dx, dy)
  }
}