package puyo

class Puyo(val x: Int, val y: Int, val color: PuyoColor.Value) extends Boba {

  override def move(dx: Int, dy: Int): Puyo = {
    new Puyo(x + dx, y + dy, color)
  }

  def isClear(dx: Int, dy: Int): Boolean = {
    x + dx >= 0 && x + dx < Board.Width && y + dy < Board.Height
  }
}